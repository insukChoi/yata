//package project.yata.config.security;
//
//
//import com.sun.security.auth.UserPrincipal;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.util.StringUtils;
//import project.yata.common.constant.Security;
//import project.yata.common.util.jwt.JsonWebTokenProvider;
//import project.yata.entity.Account;
//import project.yata.persistence.AccountRepository;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//
//public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
//
//    private final AccountRepository accountRepository;
//
//    @Autowired
//    private JsonWebTokenProvider jsonWebTokenProvider;
//
//    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, AccountRepository accountRepository) {
//        super(authenticationManager);
//        this.accountRepository = accountRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader(Security.HEADER_AUTHORIZATION);
//
//        if(StringUtils.isEmpty(header) || !header.startsWith(Security.TOKEN_PRIFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        Authentication authentication = getUsernamePasswordAuthentication(request);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(request, response);
//    }
//
//    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(Security.HEADER_AUTHORIZATION);
//        token = token.replace(Security.TOKEN_PRIFIX, "");
//
//        String email = jsonWebTokenProvider.getEmail(token);
//
//        if(email != null){
//            Account account = accountRepository.findByEmail(email);
//            UserPrincipal principal = new UserPrincipal(account.getEmail());
//            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, null, principal.getAuthorities());
//            return auth;
//        }
//
//        return null;
//    }
//}
