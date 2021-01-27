package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class PlanUpdateDto {
    private Long id;
    private Long accountId;
    private Long travelId;
    private String linkTo;
    private LocalTime time;
    private String memo;

    public PlanUpdateDto(){}
    @Builder
    public PlanUpdateDto(Long id, LocalTime  time, String memo, String linkTo) {
        this.id = id;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }
}