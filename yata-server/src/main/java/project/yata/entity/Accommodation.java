package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="ACCOMMODATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Accommodation extends BaseEntity
        implements Serializable {
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
