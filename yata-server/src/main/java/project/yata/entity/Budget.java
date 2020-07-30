package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="BUDGET")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Budget extends BaseEntity {
    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="exchange_info", nullable = false)
    private String exchangeInfo;

    @Builder
    public Budget(Long travelId, String exchangeInfo)
    {
        Assert.notNull(travelId, "Travel ID must be not null from Budget class");

        this.travelId = travelId;
        this.exchangeInfo = exchangeInfo;
    }
}
