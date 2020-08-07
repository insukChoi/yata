package project.yata.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.yata.dto.JoinRequest;
import project.yata.entity.Account;
import project.yata.service.AuthService;

import static org.mockito.BDDMockito.given;
@RunWith(MockitoJUnitRunner.class)
class AuthServiceImplTest {
    @InjectMocks
    private AuthService authService;
    private Account account;
    @Before
    public void setUp() throws Exception {
        account = Account.builder().email("admin@yata.com").name("queen").password("pulledmytriggernowhesdead").build();
    }
    @Test
    @DisplayName("회원가입 성공")
    public void successJoin() {
        // given
        final String email = account.getEmail();
        final String name = account.getName();
        final String password = account.getPassword();
        JoinRequest joinRequest = JoinRequest.builder().email(email).name(name).password(password).build();
        given(authService.join(joinRequest));
        // when
        final boolean joined = authService.join(joinRequest);
//        assertThat();
        // then
    }
}