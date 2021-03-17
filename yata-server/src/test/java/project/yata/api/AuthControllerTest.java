package project.yata.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.yata.config.security.JwtProvider;
import project.yata.config.security.UserDetailServiceImpl;
import project.yata.dto.AccountRequest;
import project.yata.dto.AccountResponse;
import project.yata.service.AuthService;
import project.yata.web.AuthController;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc
public class AuthControllerTest {

    private static final String ACCOUNT_EMAIL = "admin@yata.com";
    private static final String ACCOUNT_NAME = "jisu";
    private static final String ACCOUNT_PASSWORD = "0011";
    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();
    AccountRequest joinRequest;
    AccountResponse joinResponse;

    @MockBean
    private UserDetailServiceImpl userDetailsService;
    @MockBean
    private JwtProvider jwtProvider;
    @MockBean
    private AuthService authService;

    @Test
    @DisplayName("회원가입 성공")
    public void joinTest() throws Exception {
        // given
        join();

        // when
        mockMvc.perform(post("/api/v2/auth/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(joinRequest)))
                .andDo(print())
                // then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value("0000"))
                .andExpect(jsonPath("$.data.email").value(joinRequest.getEmail()));
    }

    @Test
    @DisplayName("로그인 성공")
    public void loginTest() throws Exception {
        // given
        join();

        // when
        mockMvc.perform(
                get("/api/v2/auth/login")
                        .header("X-USER-EMAIL", joinRequest.getEmail())
                        .header("X-USER-PASSWORD", joinRequest.getPassword()))
                // then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value("0000"));
    }

//    @Test
//    @DisplayName("로그인 없이 접근 권한 없는 페이지 접근시 실패")
//    public void requestPageWithoutAuthentication() throws Exception {
//        // given
//        join();
//
//        // when
//        mockMvc.perform(
//                get("/api/v2/account?email="+ACCOUNT_EMAIL))
//                // then
//                .andDo(print())
//                .andExpect(status().isForbidden());
//    }

    private void join() {
        joinRequest = AccountRequest.builder().email(ACCOUNT_EMAIL).name(ACCOUNT_NAME).password(ACCOUNT_PASSWORD).build();
        joinResponse = AccountResponse.builder().email(joinRequest.getEmail()).name(joinRequest.getName()).build();

        given(authService.join(Mockito.any(AccountRequest.class))).willReturn(joinResponse);
    }
}