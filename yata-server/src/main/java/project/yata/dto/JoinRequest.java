package project.yata.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class JoinRequest {

    @Email(message = "이메일 형식이 아닙니다.")
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public JoinRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
