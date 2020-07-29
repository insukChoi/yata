package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class BasicInfo implements Serializable {
    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="date")
    private LocalDateTime date; // 날짜랑 시간을 입력 받으려는데, 이렇게 사용해도 되나요?

    @Column(name="location")
    private String location;

    @Column(name="price")
    private String price;

    @Column(name="memo")
    private String memo;

    @Builder
    public BasicInfo(Long travelId, String title, LocalDateTime date,
                      String location, String price, String memo)
    {
        Assert.notNull(travelId, "Travel ID must be not null from basicInfo class");

        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.location = location;
        this.price = price;
        this.memo = memo;
    }
}
