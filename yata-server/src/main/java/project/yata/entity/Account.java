package project.yata.entity;

import lombok.*;
import org.springframework.util.StringUtils;
import project.yata.common.util.date.DateUtil;
import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="is_deleted", nullable = false)
    private int is_deleted;
    @Column(name="created_at", nullable = false)
    private String createdAt;
    @Column(name="updated_at")
    private String updatedAt;

    @Builder
    public Account(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @PrePersist
    public void prePersis() {
        if(StringUtils.isEmpty(this.createdAt))
            this.createdAt = DateUtil.getNow();
    }

    @PreUpdate
    public void preUpdate() {
        if(StringUtils.isEmpty(this.updatedAt))
            this.updatedAt = DateUtil.getNow();
    }
}
