package project.yata.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse {
    private String code;
    private Object data;

    @Builder
    public ApiResponse(String code, Object data) {
        this.code = code;
        this.data = data;
    }
}
