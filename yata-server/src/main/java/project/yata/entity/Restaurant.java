package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="RESTAURANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Restaurant extends BaseEntity {
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

    @Column(name="price")
    private String price;

    @Column(name="booking_site")
    private String bookingSite;

    @Column(name="memo")
    private String memo;

    @Builder
    public Restaurant(Long travelId, String title, LocalDateTime date,
                      String place, String picture,  String price,
                      String bookingSite, String memo)
    {
        Assert.notNull(travelId, "Travel ID must be not null from Restaurant class");

        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.place = place;
        this.picture = picture;
        this.bookingSite = bookingSite;
        this.price = price;
        this.memo = memo;
    }

}
