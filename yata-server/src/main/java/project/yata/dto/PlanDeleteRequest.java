package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanDeleteRequest {
    private Long id;
    private Long travelId;
    private boolean deleted;

    @Builder
    public PlanDeleteRequest(Long id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }
    @Builder
    public PlanDeleteRequest(Long id, Long travelId, boolean deleted) {
        this.id = id;
        this.travelId = travelId;
        this.deleted = deleted;
    }
}