package project.yata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ATTRACTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attraction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

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

    @Builder
    public Attraction(Long travelId, String title, String date,
                      String location, boolean canParking, String predictedPrice,
                      String memo, String picture)
    {
        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.location = location;
        this.canParking = canParking;
        this.predictedPrice = predictedPrice;
        this.memo = memo;
        this.picture = picture;
    }

}
