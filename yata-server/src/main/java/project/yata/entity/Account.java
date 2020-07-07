package project.yata.entity;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NonNull
    private long seq;
    @Column(name="email")
    @NonNull
    private String email;
    @Column(name="name")
    @NonNull
    private String name;
    @Column(name="is_deleted")
    @NonNull
    private int is_deleted;
    @Column(name="created_at")
    @NonNull
    private String created_at;
    @Column(name="updated_at")
    @NonNull
    private String updated_at;

}
