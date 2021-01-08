package project.yata.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import project.yata.dto.PlanUpdateDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAVEL_ID")
    private Travel travel;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "memo")
    private String memo;

    @Column(name = "linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String linkTo;

    @Builder
    public Plan(LocalTime time, String memo, String linkTo) {
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
