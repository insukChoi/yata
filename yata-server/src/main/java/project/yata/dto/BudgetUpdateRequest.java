package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BudgetUpdateRequest {
    private Long travelId;
    private String exchangeInfo;


    @Builder
    public BudgetUpdateRequest(String exchangeInfo) {
        this.exchangeInfo = exchangeInfo;
    }
}