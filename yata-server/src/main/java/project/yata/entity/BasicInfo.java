package project.yata.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class BasicInfo implements Serializable {
    @Column(name = "title", nullable = false)
    private final String title;

    @Column(name = "date")
    private final LocalDateTime date; // 날짜랑 시간을 입력 받으려는데, 이렇게 사용해도 되나요?

    @Column(name = "location")
    private final String location;

    @Column(name = "price")
    private final String price;

    @Column(name = "memo")
    private final String memo;

    @Builder
    public BasicInfo(String title, LocalDateTime date,
                     String location, String price, String memo) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.price = price;
        this.memo = memo;
    }
}
