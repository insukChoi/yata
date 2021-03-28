package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.yata.entity.Travel;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {
    @Query("SELECT distinct t from Travel t left join fetch t.plans where :accountId = t.accountId and :travelId = t.id")
//    @Query(value = "select t from Travel t where t.accountId = :accountId and t.id = :travelId")
    Travel findByAccountIdAndId(Long accountId, Long travelId);

//    @Query("SELECT distinct value(Travel) from Travel t left join Account a on t.accountId = :accountId")
//    @Query("SELECT distinct value(Travel) from Travel t where t.accountId = :accountId")
    @Query("SELECT distinct t from Travel t left join fetch t.plans where :accountId = t.accountId")
    List<Travel> findByAccountId(Long accountId);

    @Query(value = "select count(accountId) from Travel t where t.accountId = :accountId")
    int countByAccountId(Long accountId);
}