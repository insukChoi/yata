package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Travel;

import java.util.List;
import java.util.Optional;

public interface TravelRepository extends JpaRepository<Travel, Long> {
    Optional<Travel> findByAccountIdAndId(Long accountId, Long travelId);
    List<Travel> findByAccountId(Long accountId);
}
