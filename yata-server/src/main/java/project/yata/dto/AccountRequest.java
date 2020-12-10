package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    @NotNull(message = "Email cannot be an empty value.")
    private String email;
    @NotEmpty(message = "name cannot be an empty value.")
    private String name;
    @NotEmpty(message = "password cannot be an empty value.")
    private String password;
    private String gender;
    private LocalDate birthday;
    private String phone;
    private String zipCode;
    private String address1;
    private String address2;

}
