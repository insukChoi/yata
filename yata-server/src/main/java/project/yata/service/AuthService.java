package project.yata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.yata.common.constant.Security;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.common.error.exception.LoginFailedException;
import project.yata.config.security.JwtProvider;
import project.yata.dto.AccountRequest;
import project.yata.dto.AccountResponse;
import project.yata.dto.LoginResponse;
import project.yata.entity.Account;
import project.yata.entity.Address;
import project.yata.persistence.AccountRepository;

/**
 * 회원인증 서비스
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
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

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
     * @param joinRequest 회원가입 정보
     * @return {@link AccountResponse}
     */
    public AccountResponse join(AccountRequest joinRequest) {

        checkDuplicateEmail(joinRequest.getEmail());

        Account joinedAccount = accountRepository.save(getAccountByJoinRequest(joinRequest));

        return new AccountResponse(
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
    public LoginResponse login(String email, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (BadCredentialsException e) {
            throw new LoginFailedException("Incorrect email or password");
        }

        return new LoginResponse().generateTokens(
                jwtProvider.generateToken(email, Security.ACCESS.getType()),
                jwtProvider.generateToken(email, Security.REFRESH.getType())
        );
    }

    private Account getAccountByJoinRequest(AccountRequest joinRequest) {

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

