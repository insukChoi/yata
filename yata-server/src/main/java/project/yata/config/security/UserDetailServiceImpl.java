package project.yata.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final JwtProvider jwtProvider;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

        final Optional<Account> optional = accountRepository.findByEmail(email);
        final Account account = optional.orElseThrow(
                () -> new UsernameNotFoundException("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.")//
        );
        jwtProvider.setAccountId(account.getId());
        return new User(email, account.getPassword(), new ArrayList<>());
    }
}
