package project.yata.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import project.yata.common.constant.Security;
import project.yata.common.util.date.DateUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import lombok.Getter;
import lombok.Setter;

@Component
public class JwtProvider {

    @Getter
    @Setter
    private long accountId;

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.access}")
    private int accessTokenValid;

    @Value("${jwt.refresh}")
    private int refreshTokenValid;

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
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
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
                .setExpiration(
                        DateUtil.asDate(LocalDateTime.now().plusMinutes(
                                StringUtils.equals(Security.ACCESS.getType(), tokenType) ? accessTokenValid : refreshTokenValid)
                        )
                )
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
