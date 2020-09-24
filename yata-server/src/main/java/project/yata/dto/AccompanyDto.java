package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class AccompanyDto {

    private Long travelId;
    private List accompanies;


    @Builder
    public AccompanyDto(Long travelId, List accompanies) {
        this.travelId = travelId;
        this.accompanies = accompanies;
    }
}
