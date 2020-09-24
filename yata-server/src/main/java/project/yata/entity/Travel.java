package project.yata.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.yata.dto.TravelDto;
import project.yata.dto.TravelUpdateDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
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

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "place")
    private String place;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss+HH:mm", timezone = "Asia/Seoul")
    @Column(name = "time_difference")
    private ZonedDateTime timeDiff; // 나라는 입력하면, 한국 시간이랑, 그 나라의 시간이 보이도록?!

    @Column(name = "memo")
    private String memo;

    @OneToMany(targetEntity=Accompany.class)
    private List<Accompany> accompanies;

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

    public void travelUpdate(TravelUpdateDto travelUpdateDto) {
        this.title = travelUpdateDto.getTitle();
        this.place = travelUpdateDto.getPlace();

        this.timeDiff = travelUpdateDto.getTimeDiff();
        this.memo = travelUpdateDto.getMemo();
        this.startDate = travelUpdateDto.getStartDate();
        this.endDate = travelUpdateDto.getEndDate();
    }
}
