package project.yata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
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

import java.util.Optional;

/**
 * @author JisuNa
 * @version 1.0
 * @since 2020.08.25
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final JsonWebTokenProvider jsonWebTokenProvider;

    public void checkDuplicateEmail(String email) {
        if (!StringUtils.isEmpty(accountRepository.findByEmail(email)))
            throw new DuplicateEmailException();
    }

    public JoinResponse join(JoinRequest joinRequest) {

        checkDuplicateEmail(joinRequest.getEmail());

        Account joinedAccount = accountRepository.save(
                getAccountByJoinRequest(joinRequest)
        );

        return new JoinResponse(joinedAccount.getEmail(), joinedAccount.getName());
    }

    public LoginResponse login(String email, String password) {

        // Todo ID+PW 검증

        if (false) {
            throw new LoginFailedException("사용자 인증에 실패하였습니다.");
        }

        LoginResponse loginResponse = new LoginResponse().generateTokens(jsonWebTokenProvider.generateToken(email, "access"), jsonWebTokenProvider.generateToken(email, "refresh"));

        return loginResponse;
    }

    private Account getAccountByJoinRequest(JoinRequest joinRequest) {
        return Account.builder()
                .email(joinRequest.getEmail())
                .name(joinRequest.getName())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .build();
    }

}

