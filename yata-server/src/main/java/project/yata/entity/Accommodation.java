package project.yata.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ACCOMMODATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="travel_id", nullable = false)
    private long travelId;
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
    @Column(name="picture")
    private String picture;
}
