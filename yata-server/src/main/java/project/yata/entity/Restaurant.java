package project.yata.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="RESTAURANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="date")
    private String date;

    @Column(name="location")
    private String location;

    @Column(name="book_site")
    private String bookSite;

    @Column(name="price")
    private String price;

    @Column(name="memo")
    private String memo;

    @Builder
    public Restaurant(Long travelId, String title, String date,
                      String location, String bookSite, String price,
                      String memo)
    {
        this.travelId = travelId;
        this.title = title;
        this.date = date;
        this.location = location;
        this.bookSite = bookSite;
        this.price = price;
        this.memo = memo;
    }

}
