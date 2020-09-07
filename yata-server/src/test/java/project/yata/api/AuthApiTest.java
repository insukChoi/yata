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
    
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void joinSuccessTest() throws Exception {

        // when
        mockMvc.perform(post("/api/v2/auth/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(null)))
                .andDo(print())
                // then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}