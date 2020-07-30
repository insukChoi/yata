package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="PLAN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan extends BaseEntity {
    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="time", nullable = false)
    private LocalDateTime time;

    @Column(name="memo")
    private String memo;

    @Column(name="linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String linkTo;

    @Builder
    public Plan(Long travelId, LocalDateTime time, String memo, String linkTo)
    {
        Assert.notNull(travelId, "Travel ID must be not null from Plan class");

        this.travelId = travelId;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }

}
