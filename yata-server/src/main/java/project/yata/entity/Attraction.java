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
@Table(name = "ATTRACTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attraction extends BaseEntity
    implements Serializable {
    @Column(name = "travel_id", nullable = false)
    private Long travelId;

    @Column(name = "picture")
    private String picture;

    @Column(name = "can_parking")
    private boolean canParking;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Attraction(Long travelId, BasicInfo basicInfo, boolean canParking, String picture) {
        Assert.notNull(travelId, "Travel ID must be not null from Attraction class");

        this.travelId = travelId;
        this.basicInfo = basicInfo;
        this.canParking = canParking;
        this.picture = picture;
    }

}
