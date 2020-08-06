package project.yata.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import project.yata.dto.JoinRequest;
import project.yata.entity.Account;
import project.yata.service.AuthService;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;


    @Test
    void findByEmail() {

        //given
        Account account = Account.builder().email().name().password().build();
        insertAccount(account);

        accountRepository.findByEmail();
    }

    private void insertAccount(Account account) {
        accountRepository.save(account);
    }
}