package project.yata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer seq;
    @Column(name="account")
    public String account;

}
