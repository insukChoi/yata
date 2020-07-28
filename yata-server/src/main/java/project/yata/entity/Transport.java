package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TRANSPORT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Transport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="date")
    private LocalDateTime date;

    @Column(name="price")
    private String price;

    @Column(name="departure")
    private String departure;

    @Column(name="destination")
    private String destination;

    @Column(name="memo")
    private String memo;

    @Builder
    public Transport(Long travelId, String title, LocalDateTime date,
                     String price, String departure, String destination, String memo)
    {
        Assert.notNull(travelId, "Travel ID must be not null from Transport class");
        Assert.notNull(title, "Type of public transportation must be not null from Transport class");

        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
        this.memo = memo;
    }
}
