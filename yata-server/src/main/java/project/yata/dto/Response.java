package project.yata.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Response {
    private int code;
    private String data;

    @Builder
    public Response(int code, String data) {
        this.code = code;
        this.data = data;
    }
}
