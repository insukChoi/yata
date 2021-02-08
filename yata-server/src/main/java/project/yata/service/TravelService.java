package project.yata.service;

import project.yata.dto.TravelDeleteRequest;
import project.yata.dto.TravelRequest;
import project.yata.dto.TravelResponse;
import project.yata.dto.TravelUpdateRequest;
import project.yata.entity.Account;
import project.yata.entity.Travel;

import java.util.List;

public interface TravelService {
    List<Account> getAccountList();

    TravelResponse getTravelResponse(Travel travel);

    Travel travel(Long accountId, TravelRequest travelRequest);

    Travel travelInfo(Long accountId, Long travelId);

    List<Travel> travelInfos(Long accountId, int offset, int count);

    Travel updateTravel(Long accountId, TravelUpdateRequest travelUpdateRequest);

    Travel deleteTravel(Long accountId, TravelDeleteRequest travelDeleteRequest);
}