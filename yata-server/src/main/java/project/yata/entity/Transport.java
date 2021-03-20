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
@Table(name = "TRANSPORT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Transport extends BaseEntity
    implements Serializable {
    @Column(name = "travel_id", nullable = false)
    private Long travelId;

    @Column(name = "departure")
    private String departure;

    @Column(name = "destination")
    private String destination;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Transport(Long travelId, BasicInfo basicInfo, String departure, String destination) {
        Assert.notNull(travelId, "Travel ID must be not null from Transport class");

        this.travelId = travelId;
        this.basicInfo = basicInfo;
        this.departure = departure;
        this.destination = destination;
    }
}
