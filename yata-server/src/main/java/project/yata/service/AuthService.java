package project.yata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.common.error.exception.LoginFailedException;
import project.yata.common.util.jwt.JsonWebTokenProvider;
import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.dto.LoginResponse;
import project.yata.entity.Account;
import project.yata.entity.Address;
import project.yata.persistence.AccountRepository;

import java.util.Optional;

/**
 * 회원관리 서비스
 *
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

    /**
     * 이메일 중복체크
     *
     * @param email 이메일 주소
     */
    public void checkDuplicateEmail(String email) {
        accountRepository.findByEmail(email).ifPresent(value -> {
            throw new DuplicateEmailException();
        });
    }

    /**
     * 회원가입
     *
     * @param joinRequest
     * @return JoinResponse
     */
    public JoinResponse join(JoinRequest joinRequest) {

        checkDuplicateEmail(joinRequest.getEmail());

        Account joinedAccount = accountRepository.save(
                getAccountByJoinRequest(joinRequest)
        );

        return new JoinResponse(
                joinedAccount.getEmail(),
                joinedAccount.getName(),
                joinedAccount.getPhone(),
                joinedAccount.getAddress().getZipCode(),
                joinedAccount.getAddress().getAddress1(),
                joinedAccount.getAddress().getAddress2(),
                joinedAccount.getGender(),
                String.valueOf(joinedAccount.getBirthday())
        );
    }

    /**
     * 로그인
     *
     * @param email    이메일 주소
     * @param password 비밀번호
     * @return JWT
     */
    public LoginResponse login(String email, String password) {

        Optional<Account> account = accountRepository.findByEmail(email);

        account.orElseThrow(() -> new LoginFailedException("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다."));

        if (!passwordEncoder.matches(password, account.get().getPassword())) {
            throw new LoginFailedException("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
        }

        return new LoginResponse().generateTokens(
                jsonWebTokenProvider.generateToken(email, "access"),
                jsonWebTokenProvider.generateToken(email, "refresh")
        );
    }

    private Account getAccountByJoinRequest(JoinRequest joinRequest) {

        // TODO JoinRequest validation check

        return Account.builder()
                .email(joinRequest.getEmail())
                .name(joinRequest.getName())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .phone(joinRequest.getPhone())
                .address(
                        Address.builder()
                                .zipCode(joinRequest.getZipCode())
                                .address1(joinRequest.getAddress1())
                                .address2(joinRequest.getAddress2())
                                .build()
                )
                .gender(joinRequest.getGender())
                .birthday(joinRequest.getBirthday())
                .build();
    }

}

