package project.yata.service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;
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

        JoinRequest joinRequest = JoinRequest.builder().email(email).name(name).password(password).build();

        // when
        final JoinResponse joinResponse = authService.join(joinRequest);

        // then
        Assertions.assertEquals(joinResponse.getEmail(), joinRequest.getEmail());
        Assertions.assertEquals(joinResponse.getName(), joinRequest.getName());
    }
}