package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="time_difference")
    private int timeDiff; // 그 나라 시간 등록하기, 변수 타입을 뭘로 해야하나요? int or LocalDateTime

    @Column(name="memo")
    private String memo;


    @Builder
    public Travel(Long accountId, String title, String place,
                  String period,  int timeDiff, String memo)
    {
        Assert.notNull(accountId, "Account ID must be not null from Travel class");
        Assert.notNull(title, "Traveling title must be not null from Travel class");

        this.accountId = accountId;
        this.title = title;
        this.place = place;
        this.period = period;
        this.timeDiff = timeDiff;
        this.memo = memo;
    }
}
