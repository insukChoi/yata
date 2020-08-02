package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="BUDGET_ITEM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BudgetItem extends BaseEntity
        implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="budget_id", nullable = false)
    private Long budgetId;

    @Column(name="is_on_Travel", nullable = false)
    private boolean isOnTravel;

    @Column(name="date", nullable = false)
    private LocalDateTime date;

    @Column(name="price", nullable = false)
    private String price;

    @Column(name="detail", nullable = false)
    private String detail;

    @Column(name="memo")
    private String memo;

    @Builder
    public BudgetItem(Long budgetId, boolean isOnTravel, LocalDateTime date,
                      String detail, String price, String memo) {
        Assert.notNull(budgetId, "Budget ID must be not null from BudgetItem class");

        this.budgetId = budgetId;
        this.isOnTravel = isOnTravel;
        this.date = date;
        this.detail = detail;
        this.price = price;
        this.memo = memo;
    }
}
