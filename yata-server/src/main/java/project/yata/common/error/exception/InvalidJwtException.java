package project.yata.common.error.exception;

public class InvalidJwtException extends RuntimeException {
    public InvalidJwtException() {
        super("유효하지 않은 토큰입니다.");
    }
}
