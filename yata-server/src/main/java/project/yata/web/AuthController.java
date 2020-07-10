package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import project.yata.dto.JoinRequest;
import project.yata.service.AuthService;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
@RestControllerAdvice
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinRequest joinRequest) {
        authService.join(joinRequest);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/token")
    public ResponseEntity<?> getToken(@RequestHeader("X-USER-EMAIL") String email, @RequestHeader("X-USER-PASSWORD") String password) {
        return new ResponseEntity<>(authService.generateToken(email, password), HttpStatus.OK);
    }
}
