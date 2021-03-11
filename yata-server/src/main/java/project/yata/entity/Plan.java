package project.yata.entity;

import lombok.*;
import project.yata.dto.PlanUpdateRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

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
    @JoinColumn(name = "travel_id")
//    @JsonBackReference
//    @EqualsAndHashCode.Exclude
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

    public void planUpdate(PlanUpdateRequest planUpdateRequest) {
        this.time = planUpdateRequest.getTime();
        this.memo = planUpdateRequest.getMemo();
        this.linkTo = planUpdateRequest.getLinkTo();
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
