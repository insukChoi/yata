package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinResponse {

    private String email;
    private String name;

    public JoinResponse joinComplete(String email, String name) {
        this.email = email;
        this.name = name;
        return this;
    }

}
