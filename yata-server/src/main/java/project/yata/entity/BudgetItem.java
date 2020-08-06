package project.yata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="BUDGET_ITEM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BudgetItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="budget_id", nullable = false)
    private Long budgetId;

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

    @Builder
    public BudgetItem(Long budgetId, boolean isAfterTravel, String date,
                      String detail, String price, String memo)
    {
        this.budgetId = budgetId;
        this.isAfterTravel = isAfterTravel;
        this.date = date;
        this.detail = detail;
        this.price = price;
        this.memo = memo;
    }


}
