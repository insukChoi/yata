package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BudgetDeleteRequest {
    private Long travelId;
    private boolean deleted;

    @Builder
    public BudgetDeleteRequest(Long travelId, boolean deleted)
    {
        this.travelId = travelId;
        this.deleted = deleted;
    }
}