package project.yata.service;

import project.yata.dto.JoinRequest;
import project.yata.entity.Account;

public interface AuthService {
    Account join(JoinRequest joinRequest);
}
