package project.yata.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.yata.common.util.date.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseEntity
        implements Serializable {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "birthday", nullable = true)
    private LocalDate birthday;

    @Builder
    public Account(String email, String name, String password, String phone, String address, String gender, LocalDate birthday) {
        Assert.notNull(email, "e-mail must be not null from Account class");
        Assert.notNull(name, "Name must be not null from Account class");
        Assert.notNull(password, "Password must be not null from Account class");

        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
    }

}
