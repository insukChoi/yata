package project.yata.service;

import project.yata.dto.AccountRequest;
import project.yata.dto.AccountResponse;
import project.yata.dto.LoginResponse;

public interface AuthService {
    void checkDuplicateEmail(String email);
    AccountResponse join(AccountRequest joinRequest);
    LoginResponse login(String email, String password);
}
