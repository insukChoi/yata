package project.yata.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class JoinRequest {

    private String email;
    private String name;
    private String password;

    @Builder
    public JoinRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
