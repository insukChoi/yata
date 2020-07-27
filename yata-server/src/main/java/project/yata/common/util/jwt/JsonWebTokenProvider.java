package project.yata.common.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import project.yata.common.util.date.DateUtil;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Base64;
import java.util.Date;

@Component
public class JsonWebTokenProvider {

    @Value("test")
    private String secretKey;

    @Value("${jwt.access}")
    private int accessTokenValid;

    @Value("${jwt.refresh}")
    private int refreshTokenValid;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String generateToken(String email, String type) {
        Claims claims = Jwts.claims().setSubject(email);

        long tokenValid = getTokenValid(type);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("master@yata.com")
                .setIssuedAt(DateUtil.asDate(LocalDate.now()))
                .setExpiration(DateUtil.asDate(LocalDateTime.now().plusNanos(tokenValid)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch(Exception e) {
            return false;
        }
    }

    private long getTokenValid(String type) {
        // 유효시간 (Access Token: 15분, Refresh Token: 24시간)
        int min = StringUtils.equals("access", type) ? accessTokenValid : refreshTokenValid;
        return DateUtil.getMillisecond(min);
    }
}
