package project.yata.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import project.yata.common.constant.Security;
import project.yata.common.util.date.DateUtil;
import project.yata.common.util.jwt.JsonWebTokenProvider;
import project.yata.dto.LoginRequest;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
//    private final JsonWebTokenProvider jwtPrivider;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/api/v2/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        // Authenticate user
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws UnsupportedEncodingException {
//        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
//        String token = jwtPrivider.generateToken(principal.getName(), Security.TOKEN_TYPE_ACCESS);
//        response.addHeader(Security.HEADER_AUTHORIZATION, Security.TOKEN_PRIFIX + token);

        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getName())
                .withExpiresAt(DateUtil.asDate(LocalDateTime.now().plusNanos(Security.VALID_ACCESS_TOKEN)))
                .sign(Algorithm.HMAC512(Base64.getEncoder().encodeToString("aaaa".getBytes())));

        // Add token in response
        response.addHeader(Security.HEADER_AUTHORIZATION, Security.TOKEN_PRIFIX + token);

    }
}
