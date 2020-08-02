package project.yata.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequest {
    private final String email;
    private final String name;
    private final String password;

    @Builder
    public JoinRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
