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
import java.util.ArrayList;

@Entity
@Table(name = "PLAN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan extends BaseEntity
        implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRAVEL_ID"/*, insertable = false, updatable = false */)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private Travel travel;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "memo")
    private String memo;

    @Column(name = "linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String linkTo;

    @Builder
    public Plan(LocalDateTime time, String memo, String linkTo) {
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }

    public void planUpdate(PlanUpdateDto planUpdateDto) {
        this.time = planUpdateDto.getTime();
        this.memo = planUpdateDto.getMemo();
        this.linkTo = planUpdateDto.getLinkTo();
    }

    public void setTravel(Travel travel)
    {
        this.travel = travel;
        if(!travel.getPlans().contains(this))
        {
            travel.getPlans().add(this);
        }
    }
}
