package project.yata.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import project.yata.common.constant.Security;
import project.yata.common.util.jwt.JsonWebTokenProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.attribute.UserPrincipal;

@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final JsonWebTokenProvider jsonWebTokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        String accessToken = jsonWebTokenProvider.generateToken(principal.getName(), Security.TOKEN_TYPE_ACCESS);
        String refreshToken = jsonWebTokenProvider.generateToken(principal.getName(), Security.TOKEN_TYPE_REFRESH);

//        response.addHeader(Security.HEADER_AUTHORIZATIOn, );

    }

}
