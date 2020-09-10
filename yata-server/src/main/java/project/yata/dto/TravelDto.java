package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class TravelDto {

    private Long accountId;
    private String title;
    private ZonedDateTime timeDiff;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String memo;
    private String place;

    @Builder
    public TravelDto(Long accountId, String title, ZonedDateTime timeDiff, LocalDateTime startDate,
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
