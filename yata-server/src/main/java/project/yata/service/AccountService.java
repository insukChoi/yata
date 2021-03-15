package project.yata.service;

import project.yata.dto.AccountResponse;

public interface AccountService {
    AccountResponse getAccount(String email);
}
