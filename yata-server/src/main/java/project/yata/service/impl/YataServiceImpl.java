package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.entity.Account;
import project.yata.persistence.AccountRepository;
import project.yata.service.YataService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class YataServiceImpl implements YataService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }
}
