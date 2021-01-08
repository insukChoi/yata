package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class PlanDto {
    private Long accountId;
    private Long travelId;
    private String linkTo;
    private LocalTime time;
    private String memo;

    @Builder
    public PlanDto(LocalTime  time, String memo, String linkTo) {
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }
}