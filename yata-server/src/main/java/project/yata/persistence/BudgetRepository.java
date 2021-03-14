package project.yata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yata.entity.Budget;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Optional<Budget> getBudgetByTravelId(Long travelId);

    Budget findBudgetByTravelId(Long travelId);
}
