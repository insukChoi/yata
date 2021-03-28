package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.yata.entity.Plan;
import project.yata.entity.Travel;

import java.util.Set;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    int countAllByTravel(Travel travel);

    @Query("select p from Plan p where p.travel = :travel")
    Set<Plan> findAllByTravel(Travel travel);

//    @Query("SELECT distinct value(t) from Travel t join fetch t.plans p on p.id = :id and p.travel = :travel")
    @Query("select distinct p from Plan p left join fetch p.travel where p.id = :id and p.travel = :travel")
    Plan findPlanByIdAndTravel(Long id, Travel travel);
}
