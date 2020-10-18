package project.yata.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.yata.common.constant.Code;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse {
    private final String code;
    private final Object data;

    /**
     * 응답
     *
     * @param code 응답 코드
     * @param data 내용
     * @return {@link ApiResponse}
     */
    public static ApiResponse of(Code code, Object data) {
        return new ApiResponse(code.getCode(), data);
    }

    /**
     * 내용이 있는 성공 응답
     *
     * @param data 내용
     * @return {@link ApiResponse}
     */
    public static ApiResponse success(Object data) {
        return of(Code.SUCCESS, data);
    }

    /**
     * 내용이 없는 성공 응답
     *
     * @return {@link ApiResponse}
     */
    public static ApiResponse success() {
        return success(null);
    }
}
