package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
public class PlanResponse {
    private Long id;
    private String linkTo;
    private LocalTime time;
    private String memo;
}