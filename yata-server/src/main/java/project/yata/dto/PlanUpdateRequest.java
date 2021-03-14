package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class PlanUpdateRequest {
    private Long id;
    private Long travelId;
    private String linkTo;
    private LocalTime time;
    private String memo;

    @Builder
    public PlanUpdateRequest(Long id, LocalTime  time, String memo, String linkTo) {
        this.id = id;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }
}