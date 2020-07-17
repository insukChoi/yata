//package project.yata.api;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import project.yata.dto.JoinRequest;
//import project.yata.service.AuthService;
//import project.yata.web.AuthController;
//
//import javax.transaction.Transactional;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AuthController.class)
//@AutoConfigureMockMvc
//public class AuthApiTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    private AuthService authService;
//
//    @Transactional
//    @Test
//    public void joinTest() throws Exception {
//        JoinRequest joinRequest = JoinRequest.builder()
//                .email("admin@yata.com")
//                .name("지수")
//                .password("0123")
//                .build();
//
//        authService.join(joinRequest);
//
//        mockMvc.perform(
//                get("/api/v2/auth/join")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.code").value("0000"));
//
//    }
//
//
//}
