package project.yata.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JoinRequest {

    private String email;
    private String name;
    private String password;

}
