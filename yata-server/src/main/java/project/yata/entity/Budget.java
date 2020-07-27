package project.yata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="BUDGET")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Budget extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="travel_id", nullable = false)
    private Long travelId;

    @Column(name="exchange_info", nullable = false)
    private String exchangeInfo;

    @Builder
    public Budget(Long travelId, String exchangeInfo)
    {
        this.travelId = travelId;
        this.exchangeInfo = exchangeInfo;
    }
}
