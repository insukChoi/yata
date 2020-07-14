package project.yata.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Response {
    private String code;
    private Object data;

    @Builder
    public Response(String code, Object data) {
        this.code = code;
        this.data = data;
    }
}
