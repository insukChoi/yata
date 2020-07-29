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

    @Column(name="departure")
    private String departure;

    @Column(name="destination")
    private String destination;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Transport(BasicInfo basicInfo, String departure, String destination)
    {

        this.basicInfo = basicInfo;
        this.departure = departure;
        this.destination = destination;
    }
}
