package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class PlanDto {
    private Long accountId;
    private Long travelId;
    private String linkTo;
    private LocalDateTime time;
    private String memo;

    @Builder
    public PlanDto(Long accountId, Long travelId, LocalDateTime time, String memo, String linkTo) {
        this.accountId = accountId;
        this.travelId = travelId;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }
}