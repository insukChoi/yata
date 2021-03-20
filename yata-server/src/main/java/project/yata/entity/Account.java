package project.yata.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Account extends BaseEntity implements Serializable {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Embedded
    private Address address;

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "birthday", nullable = true)
    private LocalDate birthday;

}
