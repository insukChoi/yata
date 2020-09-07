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
}
