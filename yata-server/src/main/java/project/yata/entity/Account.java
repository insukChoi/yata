package project.yata.entity;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {
//test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="is_deleted", nullable = false)
    private int is_deleted;
    @Column(name="created_at", nullable = false)
    private String created_at;
    @Column(name="updated_at", nullable = false)
    private String updated_at;

    @Builder
    public Account(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
