package project.yata.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.yata.dto.AccountRequest;
import project.yata.dto.AccountResponse;
import project.yata.dto.LoginResponse;

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

        AccountRequest joinRequest = AccountRequest.builder().email(email).name(name).password(password).build();

        // when
        final AccountResponse joinResponse = authService.join(joinRequest);

        // then
        Assertions.assertEquals(joinResponse.getEmail(), joinRequest.getEmail());
        Assertions.assertEquals(joinResponse.getName(), joinRequest.getName());
    }

    @DisplayName("로그인 성공")
    @Test
    void successLogin() throws Exception {

        // given
        final String email = "admin@yata.com";
        final String name = "queen";
        final String password = "0011";

        AccountRequest joinRequest = AccountRequest.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();

        authService.join(joinRequest);

        // when
        LoginResponse loginResponse = authService.login(email, password);

        // then
        Assertions.assertNotNull(loginResponse);// 수정

    }

}