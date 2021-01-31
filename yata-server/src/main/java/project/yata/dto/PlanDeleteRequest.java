package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanDeleteRequest {
    private Long id;
    private  Long accountId;
    private Long travelId;
    private boolean deleted;

    @Builder
    public PlanDeleteRequest(Long id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }
    @Builder
    public PlanDeleteRequest(Long id, Long accountId, Long travelId, boolean deleted) {
        this.id = id;
        this.accountId = accountId;
        this.travelId = travelId;
        this.deleted = deleted;
    }
}