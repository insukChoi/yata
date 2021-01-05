package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    @NotBlank(message = "Email cannot be an empty value.")
    private String email;
    @NotBlank(message = "name cannot be an empty value.")
    private String name;
    @NotBlank(message = "password cannot be an empty value.")
    private String password;
    private String gender;
    private LocalDate birthday;
    private String phone;
    private String zipCode;
    private String address1;
    private String address2;

}
