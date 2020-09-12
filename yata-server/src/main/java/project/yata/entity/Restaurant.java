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
@Table(name = "RESTAURANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Restaurant extends BaseEntity
        implements Serializable {
    @Column(name = "travel_id", nullable = false)
    private Long travelId;

    @Column(name = "picture")
    private String picture;

    @Column(name = "booking_site")
    private String bookingSite;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Restaurant(Long travelId, BasicInfo basicInfo, String picture, String bookingSite) {
        Assert.notNull(travelId, "Travel ID must be not null from Restaurant class");

        this.travelId = travelId;
        this.basicInfo = basicInfo;
        this.picture = picture;
        this.bookingSite = bookingSite;
    }
}
