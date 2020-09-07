package project.yata.common.error.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException() {
        super("이미 등록되어 있는 이메일주소입니다.");
    }
}
