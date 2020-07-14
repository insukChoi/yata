package project.yata.service;

import project.yata.dto.JoinRequest;
import project.yata.entity.Account;

public interface AuthService {
    boolean checkDuplicateEmail(String email);
    boolean join(JoinRequest joinRequest);
    String login(String email, String password);

}
