package project.yata.service;


import project.yata.dto.BudgetDeleteRequest;
import project.yata.dto.BudgetRequest;
import project.yata.dto.BudgetResponse;
import project.yata.dto.BudgetUpdateRequest;
import project.yata.entity.Budget;

public interface BudgetService {
    Budget saveBudget(BudgetRequest budgetRequest);

    BudgetResponse getBudget(Long travelId);

    BudgetResponse updateBudget(BudgetUpdateRequest budgetUpdateRequest);

    Budget deleteBudget(Long travelId, BudgetDeleteRequest budgetDeleteRequest);
}
