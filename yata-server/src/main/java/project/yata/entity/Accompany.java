package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ACCOMPANY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Accompany extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_id", nullable = false)
    private Long accountId;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Builder
    public Accompany(Long accountId, Long travelId)
    {
        Assert.notNull(accountId, "Account ID must be not null from Accompany class");
        Assert.notNull(travelId, "Travel ID must be not null from Accompany class");

        this.accountId = accountId;
        this.travelId = travelId;
    }
}
