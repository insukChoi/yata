package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanUpdateDto {
    private Long id;
    private  Long accountId;
    private Long travelId;
    private String linkTo;
    private LocalDateTime time;
    private String memo;

    @Builder
    public PlanUpdateDto(Long id, LocalDateTime time, String memo, String linkTo) {
        this.id = id;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }
}