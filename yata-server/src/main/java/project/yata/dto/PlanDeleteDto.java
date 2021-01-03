package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanDeleteDto {
    private Long id;
    private  Long accountId;
    private Long travelId;
    private boolean deleted;


    @Builder
    public PlanDeleteDto(Long id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }
}