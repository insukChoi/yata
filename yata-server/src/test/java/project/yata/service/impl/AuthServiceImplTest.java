package project.yata.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.ActiveProfiles;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;
import project.yata.service.AuthService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private Account account;

    @Mock
    private AccountRepository repository;

    @BeforeAll
    public void setUp() {
        account = Account.builder().email("admin@yata.com").name("queen").password("pulledmytriggernowhesdead").build();
    }

    @DisplayName("회원가입 성공")
    @Test
    void successJoin() {
        // given
        final String email = account.getEmail();
        final String name = account.getName();
        final String password = account.getPassword();

        JoinRequest joinRequest = JoinRequest.builder().email(email).name(name).password(password).build();

        // when
        final JoinResponse joinResponse = authService.join(joinRequest);

        // then
        then(joinResponse).isNotNull();
        then(joinResponse.getEmail().equals(joinRequest.getEmail()));
        then(joinResponse.getName().equals(joinRequest.getName()));
    }
}