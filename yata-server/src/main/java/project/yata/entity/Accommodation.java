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
    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="booking_site")
    private String bookingSite;

    @Column(name="picture")
    private String picture;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Accommodation(Long travelId, BasicInfo basicInfo, String bookingSite, String picture) {
        Assert.notNull(travelId, "Travel ID must be not null from Accommodation class");

        this.travelId = travelId;
        this.basicInfo = basicInfo;
        this.bookingSite = bookingSite;
        this.picture = picture;
    }
}
