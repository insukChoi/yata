package project.yata.web;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import project.yata.common.constant.Code;
import project.yata.dto.JoinRequest;
import project.yata.dto.Response;
import project.yata.service.AuthService;

@Slf4j
@Api(tags = {"1. Authentication"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinRequest joinRequest) {
        return new ResponseEntity<>(Response.builder().code(Code.SUCCESS.getCode()).data(authService.join(joinRequest)).build(), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("X-USER-EMAIL") String email, @RequestHeader("X-USER-PASSWORD") String password) {
        return new ResponseEntity<>(authService.login(email, password), HttpStatus.OK);
    }
}
