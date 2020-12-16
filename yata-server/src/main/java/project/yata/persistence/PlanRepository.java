package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
