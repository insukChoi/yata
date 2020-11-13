package project.yata.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import project.yata.common.util.date.DateUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtProvider {

    @Value("secret")
    private String SECRET_KEY;

    @Value("${jwt.access}")
    private int ACCESS_TOKEN_VALID;

    @Value("${jwt.refresh}")
    private int REFRESH_TOKEN_VALID;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(DateUtil.asDate(LocalDate.now()));
    }

    public String generateToken(String username, String tokenType) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, tokenType);
    }

    private String createToken(Map<String, Object> claims, String subject, String tokenType) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(DateUtil.asDate(LocalDate.now()))
                .setExpiration(DateUtil.asDate(LocalDateTime.now().plusMinutes(StringUtils.equals("access", tokenType) ? 15 : 60)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
