package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long> {
    Travel findByAccountId(Long accountId);
}
