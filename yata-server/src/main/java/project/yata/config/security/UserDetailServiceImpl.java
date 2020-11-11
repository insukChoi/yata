package project.yata.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

	private final AccountRepository accountRepository;
//	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Account> account = accountRepository.findByEmail(email);
		account.orElseThrow(() -> new UsernameNotFoundException("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다."));

		return new User(email, account.get().getPassword(), new ArrayList<>());
	}
}
