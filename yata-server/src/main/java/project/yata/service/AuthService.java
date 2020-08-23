package project.yata.service;

import project.yata.dto.JoinRequest;
import project.yata.dto.JoinResponse;
import project.yata.dto.LoginResponse;

public interface AuthService {
    void checkDuplicateEmail(String email);

    JoinResponse join(JoinRequest joinRequest);

    LoginResponse login(String email, String password);
}
