package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Budget;

import java.util.Set;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Budget findBudgetByTravelId(Long travelId);
}
