package project.yata.service;

import project.yata.dto.TravelDeleteDto;
import project.yata.dto.TravelDto;
import project.yata.entity.Account;
import project.yata.entity.Travel;

import java.util.List;

public interface YataService {
    List<Account> getAccountList();

    Travel travel(TravelDto travelDto);

    Travel travelInfo(Long accountId, Long travelId);

    List<Travel> travelInfos(Long accountId, int offset, int count);

    Travel updateTravel(Long travelId, TravelDto travelDto);

    Travel deleteTravel(TravelDeleteDto travelDeleteDto);
}
