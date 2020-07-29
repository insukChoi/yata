package project.yata.common.error.exception;

public class LoginInputNotFoundException extends RuntimeException {
    public LoginInputNotFoundException(String message) {
        super(message);
    }
}
