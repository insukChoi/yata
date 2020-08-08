package project.yata.service;

import project.yata.dto.JoinRequest;
import project.yata.dto.TravelRequest;
import project.yata.entity.Account;

import java.util.List;

public interface YataService {
    List<Account> getAccountList();
    Long travel(TravelRequest travelRequest);

    TravelRequest travelInfo(Long accountId);
}
