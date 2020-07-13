package project.yata.service;

import project.yata.dto.JoinRequest;
import project.yata.entity.Account;

public interface AuthService {

    void checkDuplicateEmail(String email);
    boolean join(JoinRequest joinRequest);
    String generateToken(String email, String password);
}
