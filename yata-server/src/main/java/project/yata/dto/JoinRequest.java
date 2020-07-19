package project.yata.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JoinRequest {

    private final String email;
    private final String name;
    private final String password;

}
