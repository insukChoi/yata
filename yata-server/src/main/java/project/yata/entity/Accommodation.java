package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ACCOMMODATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Accommodation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="booking_site")
    private String bookingSite;

    @Column(name="picture")
    private String picture;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Accommodation(BasicInfo basicInfo, String bookingSite, String picture) {
        this.basicInfo = basicInfo;
        this.bookingSite = bookingSite;
        this.picture = picture;
    }
}
