package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.yata.entity.Travel;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("SELECT distinct t from Travel t where :accountId = t.accountId and :travelId = t.id")
    Travel findByAccountIdAndId(Long accountId, Long travelId);

    @Query("SELECT distinct t from Travel t where t.accountId = :accountId")
    List<Travel> findByAccountId(Long accountId);

    int countByAccountId(Long accountId);
}
