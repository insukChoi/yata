package project.yata.common.error;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private int code;
    private String message;

    @Builder
    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
