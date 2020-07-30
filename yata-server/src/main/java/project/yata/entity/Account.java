package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;
import org.springframework.util.StringUtils;
import project.yata.common.util.date.DateUtil;
import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseEntity {
    @Column(name="email", nullable = false)
    private String email;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="password", nullable = false)
    private String password;

    @Builder
    public Account(String email, String name, String password) {
        Assert.notNull(email, "e-mail must be not null from Account class");
        Assert.notNull(name, "Name must be not null from Account class");
        Assert.notNull(password, "Password must be not null from Account class");

        this.email = email;
        this.name = name;
        this.password = password;
    }

}
