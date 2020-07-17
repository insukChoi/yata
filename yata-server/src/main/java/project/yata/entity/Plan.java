package project.yata.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="PLAN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="travel_id", nullable = false)
    private long travelId;
    @Column(name="time", nullable = false)
    private String time;
    @Column(name="des")
    private String des;
    @Column(name="linkTo") // linkToAccomodation, linkToBudget, linkToRestaurant, linkToTrasport...?
    private String link;

}
