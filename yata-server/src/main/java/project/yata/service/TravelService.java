package project.yata.service;

import project.yata.dto.TravelDeleteDto;
import project.yata.dto.TravelDto;
import project.yata.dto.TravelUpdateDto;
import project.yata.entity.Account;
import project.yata.entity.Travel;

import java.util.List;

public interface TravelService {
    List<Account> getAccountList();

    Travel travel(TravelDto travelDto);

    Travel travelInfo(Long accountId, Long travelId);

    List<Travel> travelInfos(Long accountId, int offset, int count);

    Travel updateTravel(TravelUpdateDto travelUpdateDto);

    Travel deleteTravel(TravelDeleteDto travelDeleteDto);
}