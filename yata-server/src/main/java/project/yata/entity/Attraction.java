package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime date;

    @Column(name="place")
    private String place;

    @Column(name="picture")
    private String picture;

    @Column(name="can_parking")
    private boolean canParking;

    @Column(name="predicted_price")
    private String predictedPrice;

    @Column(name="memo")
    private String memo;


    @Builder
    public Attraction(Long travelId, String title, LocalDateTime date,
                      String location, boolean canParking, String predictedPrice,
                      String memo, String picture)
    {
        Assert.notNull(travelId, "Travel ID must be not null from Attraction class");

        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.place = place;
        this.canParking = canParking;
        this.predictedPrice = predictedPrice;
        this.memo = memo;
        this.picture = picture;
    }

}
