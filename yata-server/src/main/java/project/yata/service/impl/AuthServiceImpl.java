package project.yata.service.impl;

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
import project.yata.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public void checkDuplicateEmail(String email) {
        accountRepository.findByEmail(email).ifPresent(value -> {
            throw new DuplicateEmailException();
        });
    }

    @Override
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

    @Override
    public LoginResponse login(String email, String password) {

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

