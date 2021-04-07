package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.yata.entity.Plan;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class TravelResponse {
    private Long id;
    private String title;
    private ZonedDateTime timeDiff;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String memo;
    private String place;
    private List<Plan> plans;
    private boolean isDeleted;
}