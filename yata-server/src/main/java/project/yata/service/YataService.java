package project.yata.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class YataService {

    private final AccountRepository accountRepository;

    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }
}
