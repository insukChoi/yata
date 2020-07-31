package project.yata.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import project.yata.common.constant.Security;
import project.yata.common.util.jwt.JsonWebTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(Security.HEADER_AUTHORIZATION);

        if(StringUtils.isEmpty(header) || !header.startsWith(Security.TOKEN_PRIFIX)) {
            chain.doFilter(request, response);
            return;
        }
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(Security.HEADER_AUTHORIZATION);
        token = token.replace(Security.TOKEN_PRIFIX, "");

        if(token != null){
            // parse the token and validate it (decode)
            String username = jsonWebTokenProvider.getEmail(token);

            // Search in the DB if we find the user by token subject (username)
            // If so, then grab user details and create spring auth token using username, pass, authorities/roles
            if(username != null){
                User user = userRepository.findByUsername(username);
                UserPrincipal principal = new UserPrincipal(user);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, principal.getAuthorities());
                return auth;
            }

            return null;
        }
        return null;
    }
}
