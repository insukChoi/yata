package project.yata.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.service.AuthService;
import project.yata.web.AuthController;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc
public class AuthApiTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AuthService authService;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void joinSuccessTest() throws Exception {
        // given
        JoinRequest joinRequest = JoinRequest.builder().email("admin@yata.com").name("지수").password("0011").build();
        JoinResponse joinResponse = JoinResponse.builder().email(joinRequest.getEmail()).name(joinRequest.getName()).build();

        given(authService.join(Mockito.any(JoinRequest.class))).willReturn(joinResponse);

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
}