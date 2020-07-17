package project.yata.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ATTRACTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="travel_id", nullable = false)
    private long travelId;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="date")
    private String date;
    @Column(name="location")
    private String location;
    @Column(name="can_parking")
    private boolean canParking;
    @Column(name="predicted_price")
    private String predictedPrice;
    @Column(name="memo")
    private String memo;
    @Column(name="picture")
    private String picture;

}
