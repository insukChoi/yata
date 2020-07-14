package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
    public Account join(JoinRequest joinRequest) {

        Account account = Account.builder()
                .email(joinRequest.getEmail())
                .name(joinRequest.getName())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .build();
        return accountRepository.save(account);
    }
}
