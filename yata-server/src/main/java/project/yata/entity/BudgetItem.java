package project.yata.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="BUDGET_ITEM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BudgetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="budget_id", nullable = false)
    private long budgetId;
    @Column(name="is_after", nullable = false)
    private boolean isAfterTravel;
    @Column(name="date", nullable = false)
    private String date;
    @Column(name="detail", nullable = false)
    private String detail;
    @Column(name="price", nullable = false)
    private String price;
    @Column(name="memo")
    private String memo;


}
