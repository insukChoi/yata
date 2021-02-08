package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TravelDeleteRequest {
    private Long id;
    private boolean deleted;

    @Builder
    public TravelDeleteRequest(Long id, boolean deleted)
    {
        this.id = id;
        this.deleted = deleted;
    }
}