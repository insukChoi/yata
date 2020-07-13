package project.yata.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.yata.common.constant.Code;
import project.yata.common.error.exception.DuplicateEmailException;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({DuplicateEmailException.class})
    protected ResponseEntity<ErrorResponse> duplicateEmailException(DuplicateEmailException e) {
        return new ResponseEntity<>(ErrorResponse.builder().code(Code.ERROR0001.getCode()).message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

}
