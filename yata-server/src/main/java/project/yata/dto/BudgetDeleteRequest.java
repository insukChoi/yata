package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class BudgetDeleteRequest {
    private Long travelId;
    private boolean deleted;

    public BudgetDeleteRequest(Long travelId, boolean deleted)
    {
        this.travelId = travelId;
        this.deleted = deleted;
    }
}