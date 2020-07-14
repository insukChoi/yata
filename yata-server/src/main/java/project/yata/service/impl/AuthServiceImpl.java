package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.common.error.exception.JoinFailedException;
import project.yata.common.error.exception.LoginFailedException;
import project.yata.common.util.jwt.JsonWebTokenProvider;
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
    public boolean checkDuplicateEmail(String email) {
        if(!StringUtils.isEmpty(accountRepository.findByEmail(email)))
            throw new DuplicateEmailException("이미 등록되어 있는 이메일주소입니다.");
        return true;
    }

    @Override
    public boolean join(JoinRequest joinRequest) {

        checkDuplicateEmail(joinRequest.getEmail());

        Account account = Account.builder()
                .email(joinRequest.getEmail())
                .name(joinRequest.getName())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .build();

        if(!StringUtils.isEmpty(accountRepository.save(account)))
            throw new JoinFailedException("회원가입에 문제가 발생하였습니다.");

        return true;
    }

    @Override
    public String login(String email, String password) {

        // Todo ID+PW 검증

        if(false)
            throw new LoginFailedException("사용자 인증에 실패하였습니다.");

        JsonWebTokenProvider jsonWebTokenProvider = new JsonWebTokenProvider();
        return jsonWebTokenProvider.generateToken(email);
    }
}