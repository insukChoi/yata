package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Builder
@NoArgsConstructor
public class TravelUpdateRequest {

    private Long id;
    private String title;
    private ZonedDateTime timeDiff;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String memo;
    private String place;

    public TravelUpdateRequest(Long id, String title, ZonedDateTime timeDiff, LocalDateTime startDate,
                               LocalDateTime endDate, String memo, String place) {
        this.id = id;
        this.title = title;
        this.timeDiff = timeDiff;
        this.startDate = startDate;
        this.endDate = endDate;
        this.memo = memo;
        this.place = place;
    }
}