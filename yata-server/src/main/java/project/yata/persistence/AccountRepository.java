package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
