package project.yata.entity;

import lombok.AccessLevel;
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
    private long id;
    @Column(name="travel_id", nullable = false)
    private long travelId;
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
}
