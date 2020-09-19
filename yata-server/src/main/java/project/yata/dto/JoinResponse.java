package project.yata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class JoinResponse {
    private final String email;
    private final String name;
    private final String phone;
    private final String address;
    private final String gender;
    private final String birthday;
}
