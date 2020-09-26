package project.yata.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.yata.common.constant.Code;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.common.error.exception.JoinFailedException;
import project.yata.common.error.exception.LoginFailedException;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({EmptyInfoException.class})
    protected ResponseEntity<ErrorResponse> missRequiredValueException(Exception e) {
        return new ResponseEntity<>(ErrorResponse.builder().code(Code.ERROR0001.getCode())
                .message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DuplicateEmailException.class})
    protected ResponseEntity<ErrorResponse> duplicateException(Exception e) {
        return new ResponseEntity<>(ErrorResponse.builder().code(Code.ERROR0002.getCode())
                .message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JoinFailedException.class, LoginFailedException.class})
    protected ResponseEntity<ErrorResponse> invalidInfoException(Exception e) {
        return new ResponseEntity<>(ErrorResponse.builder().code(Code.ERROR0003.getCode())
                .message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}
