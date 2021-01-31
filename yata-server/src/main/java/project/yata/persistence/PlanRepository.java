package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Plan;
import project.yata.entity.Travel;

import java.util.Set;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    int countAllByTravel(Travel travel);

    Set<Plan> findAllByTravel(Travel travel);

    Plan findPlanByIdAndTravel(Long id, Travel travel);
}
