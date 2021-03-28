package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.yata.entity.Plan;
import project.yata.entity.Travel;

import java.util.Set;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    int countAllByTravel(Travel travel);

//    @Query("SELECT p from Plan p left join p.travel tr on tr = :travel")
    Set<Plan> findAllByTravel(Travel travel);

//    @Query("SELECT distinct p from Plan p join fetch p.travel tr on p.id = :id and tr = :travel")
    Plan findPlanByIdAndTravel(Long id, Travel travel);
}
