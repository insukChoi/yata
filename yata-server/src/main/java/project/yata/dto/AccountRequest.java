package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AccountRequest {
    private String email;
    private String name;
    private String password;
    private String gender;
    private LocalDate birthday;
    private String phone;
    private String zipCode;
    private String address1;
    private String address2;

    @Builder
    public AccountRequest(String email, String name, String password, String gender, LocalDate birthday, String phone, String zipCode, String address1, String address2) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.zipCode = zipCode;
        this.address1 = address1;
        this.address2 = address2;
    }
}