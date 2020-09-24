package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOMPANY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Accompany extends BaseEntity
        implements Serializable {
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "travel_id", nullable = false)
    private Long travelId;


    @ManyToOne
    private Travel travel;

    @Builder
    public Accompany(Long accountId, Long id) {
        Assert.notNull(accountId, "Account ID must be not null from Accompany class");
        Assert.notNull(travelId, "Travel ID must be not null from Accompany class");

        this.accountId = accountId;
        this.travelId = travelId;
    }
}
