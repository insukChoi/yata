package project.yata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="PLAN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="time", nullable = false)
    private String time;

    @Column(name="memo")
    private String memo;

    @Column(name="linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String linkTo;

    @Builder
    public Plan(Long travelId, String time, String memo, String linkTo)
    {
        this.travelId = travelId;
        this.time = time;
        this.memo = memo;
        this.linkTo = linkTo;
    }

}
