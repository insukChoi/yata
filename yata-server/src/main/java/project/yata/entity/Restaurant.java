package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="RESTAURANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="picture")
    private String picture;

    @Column(name="booking_site")
    private String bookingSite;

    @Embedded
    private BasicInfo basicInfo;

    @Builder
    public Restaurant(BasicInfo basicInfo, String picture, String bookingSite)
    {
        this.basicInfo = basicInfo;
        this.picture = picture;
        this.bookingSite = bookingSite;
    }

}
