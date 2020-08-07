package project.yata.persistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.StringUtils;
import project.yata.entity.Account;
import javax.transaction.Transactional;
import static org.assertj.core.api.BDDAssertions.then;

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
        then(!StringUtils.isEmpty(member));
        then(account.getEmail()).isEqualTo(member.getEmail());
        then(account.getName()).isEqualTo(member.getName());
        then(account.getPassword()).isEqualTo(member.getPassword());
    }
    private void insertAccount(Account account) {
        accountRepository.save(account);
    }
}