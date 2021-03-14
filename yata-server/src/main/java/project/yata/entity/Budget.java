package project.yata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.yata.dto.BudgetUpdateRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BUDGET")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Budget extends BaseEntity implements Serializable {
    @Column(name = "travel_id", nullable = false)
    private Long travelId;

    @Column(name = "exchange_info") // 환전 정보
    private String exchangeInfo;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<BudgetItem> budgetItems;

    @Builder
    public Budget(Long travelId, String exchangeInfo) {
        Assert.notNull(travelId, "Travel ID must be not null from Budget class");

        this.travelId = travelId;
        this.exchangeInfo = exchangeInfo;
    }

    public void budgetUpdate(BudgetUpdateRequest budgetUpdateRequest)
    {
        this.exchangeInfo = exchangeInfo;
    }
}
