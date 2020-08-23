package project.yata.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    AuthService authService;

    @DisplayName("회원가입 성공")
    @Test
    void successJoin() throws Exception {
        // given
        final String email = "admin@yata.com";
        final String name = "queen";
        final String password = "pulledmytriggernowhesdead";

        JoinRequest joinRequest = JoinRequest.builder().email(email).name(name).password(password).build();

        // when
        final JoinResponse joinResponse = authService.join(joinRequest);

        // then
        assertThat(joinResponse.getEmail(), Matchers.is(joinRequest.getEmail()));
        assertThat(joinResponse.getName(), Matchers.is(joinRequest.getName()));
    }
}