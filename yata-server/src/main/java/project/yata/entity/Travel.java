package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="TRAVEL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Travel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_id", nullable = false)
    private Long accountId;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="place")
    private String place;

    @Column(name="period")
    private String period;

    @Column(name="accompany")
    private String accompany;

    @Column(name="time")
    private String time;

    @Column(name="memo")
    private String memo;

    @Builder
    public Travel(Long accountId, String title, String place,
                  String period, String accompany, String time, String memo)
    {
        Assert.notNull(accountId, "Account ID must be not null");
        Assert.notNull(title, "Traveling titile must be not null");

        this.accountId = accountId;
        this.title = title;
        this.place = place;
        this.period = period;
        this.accompany = accompany;
        this.time = time;
        this.memo = memo;
    }
}
