package project.yata.entity;

import lombok.*;
import org.springframework.util.StringUtils;
import project.yata.common.util.date.DateUtil;
import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="password", nullable = false)
    private String password;

    @Builder
    public Account(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}
