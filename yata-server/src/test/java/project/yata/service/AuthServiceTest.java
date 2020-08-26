package project.yata.service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;

import static org.hamcrest.MatcherAssert.assertThat;

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

        JoinRequest joinRequest = new JoinRequest();
        joinRequest.setEmail(email);
        joinRequest.setName(name);
        joinRequest.setPassword(password);

        // when
        final JoinResponse joinResponse = authService.join(joinRequest);

        // then
        assertThat(joinResponse.getEmail(), Matchers.is(joinRequest.getEmail()));
        assertThat(joinResponse.getName(), Matchers.is(joinRequest.getName()));
    }
}