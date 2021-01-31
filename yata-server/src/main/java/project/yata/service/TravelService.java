package project.yata.service;

import project.yata.dto.TravelDeleteRequest;
import project.yata.dto.TravelRequest;
import project.yata.dto.TravelUpdateRequest;
import project.yata.entity.Account;
import project.yata.entity.Travel;

import java.util.List;

public interface TravelService {
    List<Account> getAccountList();

    Travel travel(TravelRequest travelRequest);

    Travel travelInfo(Long accountId, Long travelId);

    List<Travel> travelInfos(Long accountId, int offset, int count);

    Travel updateTravel(TravelUpdateRequest travelUpdateRequest);

    Travel deleteTravel(TravelDeleteRequest travelDeleteRequest);
}