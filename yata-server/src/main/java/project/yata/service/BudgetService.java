package project.yata.service;


import project.yata.dto.BudgetDeleteRequest;
import project.yata.dto.BudgetRequest;
import project.yata.dto.BudgetResponse;
import project.yata.dto.BudgetUpdateRequest;
import project.yata.entity.Budget;

public interface BudgetService {
    Budget budget(BudgetRequest budgetRequest);

    BudgetResponse getBudgetResponse(Budget budget);

    BudgetResponse budgetInfo(Long travelId);

    BudgetResponse updateBudget(BudgetUpdateRequest budgetUpdateRequest);

    BudgetResponse deleteBudget(Long travelId, BudgetDeleteRequest budgetDeleteRequest);
}
