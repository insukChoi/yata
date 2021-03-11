package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.BudgetDeleteRequest;
import project.yata.dto.BudgetRequest;
import project.yata.dto.BudgetResponse;
import project.yata.dto.BudgetUpdateRequest;
import project.yata.entity.Budget;
import project.yata.persistence.BudgetRepository;
import project.yata.service.BudgetService;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;
    @Override
    public Budget saveBudget(BudgetRequest budgetRequest) {
        Budget budget = Budget.builder()
                .travelId(budgetRequest.getTravelId())
                .exchangeInfo(budgetRequest.getExchangeInfo())
                .build();

        if(budgetRepository.findBudgetByTravelId(budgetRequest.getTravelId()) != null)
            throw new EmptyInfoException("The budget is already created, you can create budget only one.");

        return budgetRepository.save(budget);
    }

    @Override
    public BudgetResponse getBudgetResponse(Budget budget) {
        return BudgetResponse.builder()
                .travelId(budget.getTravelId())
                .exchangeInfo(budget.getExchangeInfo())
                .build();
    }

    @Override
    public BudgetResponse getBudget(Long travelId) {
        return getBudgetResponse(budgetRepository.findBudgetByTravelId(travelId));
    }

    @Override
    public BudgetResponse updateBudget(BudgetUpdateRequest budgetUpdateRequest) {
        Budget budget = budgetRepository.findBudgetByTravelId(budgetUpdateRequest.getTravelId());
        budget.budgetUpdate(budgetUpdateRequest);

        budgetRepository.save(budget);
        return getBudgetResponse(budget);
    }

    @Override
    public Budget deleteBudget(Long travelId, BudgetDeleteRequest budgetDeleteRequest) {
        Budget budget = budgetRepository.findBudgetByTravelId(travelId);
        budget.updateDelete(budgetDeleteRequest.isDeleted());

        return budgetRepository.save(budget);
    }
}
