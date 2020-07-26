package project.yata.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.StringUtils;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners({Accommodation.class, Account.class, Attraction.class, Budget.class, Plan.class, Restaurant.class, Transport.class, Travel.class})
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean isDeleted;

    @PrePersist
    public void prePersis() {
        if(StringUtils.isEmpty(this.createdAt))
            this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        if(StringUtils.isEmpty(this.updatedAt))
            this.updatedAt = LocalDateTime.now();
    }
}
