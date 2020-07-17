package project.yata.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="BUDGET")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="travel_id", nullable = false)
    private long travelId;
    @Column(name="exchange_info", nullable = false)
    private long exchangeInfo;
}
