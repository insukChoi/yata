package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ACCOMMODATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Accommodation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="date")
    private LocalDateTime date; // 날짜랑 시간을 입력 받으려는데, 이렇게 사용해도 되나요?

    @Column(name="location")
    private String location;

    @Column(name="booking_site")
    private String bookingSite;

    @Column(name="price")
    private String price;

    @Column(name="memo")
    private String memo;

    @Column(name="picture")
    private String picture;

    @Builder
    public Accommodation(Long travelId, String title,
                         LocalDateTime date, String location, String bookingSite,
                         String price, String memo, String picture) {
        Assert.notNull(travelId, "Travel ID must be not null from Accommodation class");

        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.location = location;
        this.bookingSite = bookingSite;
        this.price = price;
        this.memo = memo;
        this.picture = picture;
    }
}
