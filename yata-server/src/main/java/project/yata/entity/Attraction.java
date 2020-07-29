package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ATTRACTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attraction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="picture")
    private String picture;

    @Column(name="can_parking")
    private boolean canParking;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Attraction(BasicInfo basicInfo, boolean canParking, String picture)
    {
        this.basicInfo = basicInfo;
        this.canParking = canParking;
        this.picture = picture;
    }

}
