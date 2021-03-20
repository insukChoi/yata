package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.config.security.JwtProvider;
import project.yata.dto.*;
import project.yata.entity.Budget;
import project.yata.service.BudgetService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BudgetController {
    private final BudgetService budgetService;
    private final JwtProvider jwtProvider;

    // budget은 travel마다 하나만 생성가능
    @PostMapping("/budget")
    public ResponseEntity<ApiResponse> budget(@RequestBody BudgetRequest budgetRequest) {
        final Budget saveBudget = budgetService.saveBudget(budgetRequest);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header(HttpHeaders.LOCATION, "/budget/" + saveBudget.getId())
            .body(
                ApiResponse.success(
                    saveBudget
                )
            );
    }

    @GetMapping("/budget")
    public ResponseEntity<BudgetResponse> budgetItemList(@RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(budgetService.getBudget(travelId), HttpStatus.OK);
    }

    @PutMapping("/budget")
    public ResponseEntity<BudgetResponse> updateBudget(@RequestBody BudgetUpdateRequest budgetUpdateRequest) {
        return new ResponseEntity<>(budgetService.updateBudget(budgetUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/budget")
    public ResponseEntity<Budget> updateBudget(@RequestBody BudgetDeleteRequest budgetDeleteRequest) {
        return new ResponseEntity<>(budgetService.deleteBudget(jwtProvider.getAccountId(), budgetDeleteRequest), HttpStatus.OK);
    }
}
