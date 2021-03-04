package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class BudgetRequest {
    private Long travelId;
    private String exchangeInfo;

    @Builder
    public BudgetRequest(Long travelId, String exchangeInfo) {
        this.travelId = travelId;
        this.exchangeInfo = exchangeInfo;
    }
}