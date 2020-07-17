package project.yata.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TRAVEL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="account_id", nullable = false)
    private long accountId;
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
    @Column(name="description")
    private String description;


}
