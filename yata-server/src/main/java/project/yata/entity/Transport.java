package project.yata.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="TRANSPORT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="date")
    private String date;

    @Column(name="time")
    private String time;

    @Column(name="price")
    private String price;

    @Column(name="departure")
    private String departure;

    @Column(name="destination")
    private String destination;

    @Builder
    public Transport(Long travelId, String name, String date,
                     String time, String price, String departure, String destination)
    {
        this.travelId = travelId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
    }
}
