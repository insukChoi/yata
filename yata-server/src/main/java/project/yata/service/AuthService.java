package project.yata.service;

import project.yata.dto.JoinRequest;
import project.yata.dto.LoginResponse;

public interface AuthService {
    void checkDuplicateEmail(String email);

    boolean join(JoinRequest joinRequest);

    LoginResponse login(String email, String password);
}
