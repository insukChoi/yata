package project.yata.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import project.yata.common.constant.Security;
import project.yata.common.error.exception.LoginInputNotFoundException;
import project.yata.common.util.jwt.JsonWebTokenProvider;
import project.yata.dto.LoginRequest;
import project.yata.dto.LoginResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JsonWebTokenProvider jsonWebTokenProvider;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest;

        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
            authRequest = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        } catch(IOException e) {
            throw new LoginInputNotFoundException("로그인 정보를 입력해주세요.");
        }

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        // Create JWT Token
        String accessToken = jsonWebTokenProvider.generateToken(principal.getName(), Security.TOKEN_TYPE_ACCESS);
        String refreshToken = jsonWebTokenProvider.generateToken(principal.getName(), Security.TOKEN_TYPE_REFRESH);

        response.addHeader(Security.HEADER_AUTHORIZATION, Security.TOKEN_PRIFIX+accessToken);

    }
}
