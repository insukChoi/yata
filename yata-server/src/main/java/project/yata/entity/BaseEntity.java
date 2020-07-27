package project.yata.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
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

        if(StringUtils.isEmpty(this.isDeleted))
            this.isDeleted = false;
    }

    @PreUpdate
    public void preUpdate() {
        if(StringUtils.isEmpty(this.updatedAt))
            this.updatedAt = LocalDateTime.now();
    }
}
