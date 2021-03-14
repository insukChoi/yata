package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Builder
@NoArgsConstructor
public class TravelRequest {
    private Long accountId;
    private String title;
    private ZonedDateTime timeDiff;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String memo;
    private String place;

    public TravelRequest(Long accountId, String title, ZonedDateTime timeDiff, LocalDateTime startDate,
                         LocalDateTime endDate, String memo, String place) {
        this.accountId = accountId;
        this.title = title;
        this.timeDiff = timeDiff;
        this.startDate = startDate;
        this.endDate = endDate;
        this.memo = memo;
        this.place = place;
    }
}