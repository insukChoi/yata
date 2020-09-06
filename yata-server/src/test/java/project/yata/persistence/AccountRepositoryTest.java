package project.yata.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.StringUtils;
import project.yata.entity.Account;

import javax.transaction.Transactional;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void findByEmail() {

        //given
        Account account = Account.builder().email("admin@yata.com").name("queen").password("pulledmytriggernowhesdead").build();

        insertAccount(account);

        Account member = accountRepository.findByEmail(account.getEmail());

        Assertions.assertTrue(!StringUtils.isEmpty(member));
        Assertions.assertEquals(account.getEmail(), member.getEmail());
        Assertions.assertEquals(account.getName(), member.getName());
        Assertions.assertEquals(account.getPassword(), member.getPassword());
    }

    private void insertAccount(Account account) {
		accountRepository.save(account);
	}
}