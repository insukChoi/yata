package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TravelDto {
    private Long accountId;
    private String title;
    private String place;
    private String memo;
}
