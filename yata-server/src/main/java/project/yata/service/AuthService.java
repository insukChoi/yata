package project.yata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.common.error.exception.JoinFailedException;
import project.yata.common.error.exception.LoginFailedException;
import project.yata.common.util.jwt.JsonWebTokenProvider;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.dto.LoginResponse;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final JsonWebTokenProvider jsonWebTokenProvider;

    public boolean checkDuplicateEmail(String email) {
        if(!StringUtils.isEmpty(accountRepository.findByEmail(email)))
            throw new DuplicateEmailException("이미 등록되어 있는 이메일주소입니다.");
        return true;
    }

    public JoinResponse join(JoinRequest joinRequest) {

        checkDuplicateEmail(joinRequest.getEmail());

        Account account = Account.builder()
                .email(joinRequest.getEmail())
                .name(joinRequest.getName())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .build();

        Account joinResult = accountRepository.save(account);

        if(StringUtils.isEmpty(joinResult))
            throw new JoinFailedException("회원가입에 문제가 발생하였습니다.");

        return new JoinResponse().joinComplete(joinResult.getEmail(), joinResult.getName());
    }

    public LoginResponse login(String email, String password) {

        // Todo ID+PW 검증
        boolean authentication = checkEmailWithPassword();

        if(authentication)
            throw new LoginFailedException("사용자 인증에 실패하였습니다.");

        String accessToken = jsonWebTokenProvider.generateToken(email, "access");
        String refreshToken = jsonWebTokenProvider.generateToken(email, "refresh");

        return new LoginResponse().generateTokens(accessToken, refreshToken);
    }

    private boolean checkEmailWithPassword() {


        return true;
    }
}

