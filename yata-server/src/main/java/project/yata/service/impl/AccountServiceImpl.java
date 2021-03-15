package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.AccountResponse;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;
import project.yata.service.AccountService;

/**
 * 회원관리 서비스
 *
 * @author JisuNa
 * @version 1.0
 * @since 20.10.18
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    /**
     * 회원 조회
     *
     * @param email 조회 키워드
     * @return AccountResponse
     */
    @Override
    public AccountResponse getAccount(String email) {
        Account account = accountRepository.findByEmail(email).orElseThrow(() ->
                new EmptyInfoException("There is no " + email + "."));

        return AccountResponse.builder()
                .email(account.getEmail())
                .name(account.getName())
                .phone(account.getPhone())
                .zipCode(account.getAddress().getZipCode())
                .address1(account.getAddress().getAddress1())
                .address2(account.getAddress().getAddress2())
                .gender(account.getGender())
                .birthday(String.valueOf(account.getBirthday()))
                .build();
    }

}
