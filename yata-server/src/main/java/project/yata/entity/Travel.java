package project.yata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.lang.Assert;
import lombok.*;
import project.yata.dto.TravelUpdateRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "TRAVEL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Travel extends BaseEntity
        implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Plan> plans;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "place")
    private String place;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "time_difference")
    private ZonedDateTime timeDiff; // 나라는 입력하면, 한국 시간이랑, 그 나라의 시간이 보이도록?!

    @Column(name = "memo")
    private String memo;

    @Builder
    public Travel(Long accountId, String title, String place,
                  ZonedDateTime timeDiff, String memo,
                  LocalDateTime startDate, LocalDateTime endDate) {
        Assert.notNull(accountId, "Account ID must be not null from Travel class");
        Assert.notNull(title, "Traveling title must be not null from Travel class");

        this.accountId = accountId;
        this.title = title;
        this.place = place;
        this.timeDiff = timeDiff;
        this.memo = memo;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void travelUpdate(TravelUpdateRequest travelUpdateRequest) {
        this.title = travelUpdateRequest.getTitle();
        this.place = travelUpdateRequest.getPlace();

        this.timeDiff = travelUpdateRequest.getTimeDiff();
        this.memo = travelUpdateRequest.getMemo();
        this.startDate = travelUpdateRequest.getStartDate();
        this.endDate = travelUpdateRequest.getEndDate();
    }
}