package project.yata.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;
import project.yata.service.AuthService;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@AutoConfigureMockMvc
class AuthServiceImplTest {

    @Autowired
    AuthService authService;

    @Autowired
    AccountRepository repository;

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
        then(joinResponse).isNotNull();
        then(joinResponse.getEmail().equals(joinRequest.getEmail()));
        then(joinResponse.getName().equals(joinRequest.getName()));
    }
}