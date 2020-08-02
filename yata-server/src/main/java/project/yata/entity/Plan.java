package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="PLAN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan extends BaseEntity
        implements Serializable {
    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="time", nullable = false)
    private LocalDateTime time;

    @Column(name="memo")
    private String memo;

    @Column(name="linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String linkTo;

    @Builder
    public Plan(Long travelId, LocalDateTime time, String memo, String linkTo) {
        Assert.notNull(travelId, "Travel ID must be not null from Plan class");

        this.travelId = travelId;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }

}
