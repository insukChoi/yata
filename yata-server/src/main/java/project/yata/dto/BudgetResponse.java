package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class BudgetResponse {
    private Long travelId;
    private String exchangeInfo;
    private boolean isDeleted;
}