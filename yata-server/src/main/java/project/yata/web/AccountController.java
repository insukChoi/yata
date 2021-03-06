package project.yata.web;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.yata.dto.ApiResponse;
import project.yata.service.AccountService;

@Api(tags = {"2. Account"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("")
    public ResponseEntity<ApiResponse> getAccount(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.success(accountService.getAccount(email)));
    }
}
