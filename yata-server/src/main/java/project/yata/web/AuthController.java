package project.yata.web;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.dto.AccountRequest;
import project.yata.dto.ApiResponse;
import project.yata.service.AuthService;

import javax.validation.Valid;

@Slf4j
@Api(tags = {"1. Authentication"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<ApiResponse> join(@Valid @RequestBody AccountRequest joinRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, "/api/v2/account?email=" + joinRequest.getEmail())
                .body(ApiResponse.success(authService.join(joinRequest)));
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestHeader("X-USER-EMAIL") String email,
                                             @RequestHeader("X-USER-PASSWORD") String password) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(authService.login(email, password)));
    }
}
