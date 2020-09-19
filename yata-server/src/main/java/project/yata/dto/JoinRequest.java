package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class JoinRequest {
    private String email;
    private String name;
    private String password;
    private String gender;
    private String birthday;
    private String phone;
    private String address;

    @Builder
    public JoinRequest(String email, String name, String password, String gender, String birthday, String phone, String address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
    }
}
