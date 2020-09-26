package project.yata.web;

import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.common.constant.Code;
import project.yata.dto.JoinRequest;
import project.yata.dto.Response;
import project.yata.entity.Account;
import project.yata.service.AuthService;

@Slf4j
@Api(tags = {"1. Authentication"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<Response> join(@NonNull @RequestBody JoinRequest joinRequest) {

        return new ResponseEntity<>(
                Response.builder()
                        .code(Code.SUCCESS.getCode())
                        .data(authService.join(joinRequest))
                        .build()
                , HttpStatus.CREATED
        );
    }

    @GetMapping("/login")
    public ResponseEntity<Response> login(@RequestHeader("X-USER-EMAIL") String email, @RequestHeader("X-USER-PASSWORD") String password) {
        return new ResponseEntity<>(
                Response.builder()
                        .code(Code.SUCCESS.getCode())
                        .data(authService.login(email, password))
                        .build()
                , HttpStatus.OK
        );
    }
}
