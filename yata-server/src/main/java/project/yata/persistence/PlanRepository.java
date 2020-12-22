package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Plan;
import project.yata.entity.Travel;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findPlansByAccountIdAndTravelId(Long accountId, Long travelId);
    int countPlansByAccountIdAndTravelId(Long accountId, Long travelId);

    Travel findByAccountIdAndTravelId(Long accountId, Long travelId);
    Plan findPlanByIdAndAccountIdAndTravelId(Long id, Long accountId, Long travelId);
}
