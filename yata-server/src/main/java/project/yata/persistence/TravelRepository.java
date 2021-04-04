package project.yata.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.yata.entity.Travel;

import java.util.Optional;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("FROM Travel t JOIN FETCH t.plans WHERE t.accountId = :accountId AND t.id = :travelId")
    Optional<Travel> findTravelAndPlanByAccountIdAndId(Long accountId, Long travelId);

    Optional<Travel> findByAccountIdAndId(Long accountId, Long travelId);

    Page<Travel> findByAccountId(Long accountId, Pageable pageable);
}