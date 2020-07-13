package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.dto.JoinRequest;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;
import project.yata.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    public void checkDuplicateEmail(String email) {
        if(!StringUtils.isEmpty(accountRepository.findByEmail(email)))
            throw new DuplicateEmailException("이미 등록되어 있는 이메일주소입니다.");
    }

    @Override
    public boolean join(JoinRequest joinRequest) {

        checkDuplicateEmail(joinRequest.getEmail());

        Account account = Account.builder()
                .email(joinRequest.getEmail())
                .name(joinRequest.getName())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .build();
        return !StringUtils.isEmpty(accountRepository.save(account));
    }

    @Override
    public String generateToken(String email, String password) {
        return "";
    }
}