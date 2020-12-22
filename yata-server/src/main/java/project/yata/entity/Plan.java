package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.yata.dto.PlanUpdateDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PLAN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan extends BaseEntity
        implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "travel_id", nullable = false)
    private Long travelId;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "memo")
    private String memo;

    @Column(name = "linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String linkTo;

    @Builder
    public Plan(Long accountId, Long travelId, LocalDateTime time, String memo, String linkTo) {
        Assert.notNull(accountId, "Account ID must be not null in Plan class");
        Assert.notNull(travelId, "Travel ID must be not null in Plan class");

        this.accountId = accountId;
        this.travelId = travelId;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }

    public void planUpdate(PlanUpdateDto planUpdateDto) {
        this.time = planUpdateDto.getTime();
        this.memo = planUpdateDto.getMemo();
        this.linkTo = planUpdateDto.getLinkTo();
    }
}
