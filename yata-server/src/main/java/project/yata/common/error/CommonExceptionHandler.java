package project.yata.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.yata.common.constant.Code;
import project.yata.common.error.exception.DuplicateEmailException;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.common.error.exception.JoinFailedException;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({DuplicateEmailException.class, JoinFailedException.class})
    protected ResponseEntity<ErrorResponse> duplicateEmailException(DuplicateEmailException e) {
        return new ResponseEntity<>(ErrorResponse.builder().code(Code.ERROR0002.getCode())
                .message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EmptyInfoException.class})
    protected ResponseEntity<ErrorResponse> emptyInfoException(EmptyInfoException e) {
        return new ResponseEntity<>(ErrorResponse.builder().code(Code.ERROR0002.getCode())
                .message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

}
