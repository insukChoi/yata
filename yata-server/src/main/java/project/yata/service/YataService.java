package project.yata.service;

import project.yata.dto.TravelDto;
import project.yata.entity.Account;
import project.yata.entity.Travel;

import java.util.List;

public interface YataService {
    List<Account> getAccountList();
    Travel travel(TravelDto travelDto);
    Travel travelInfo(Long accountId, Long travelId);
    List<Travel> travelInfos(Long accountId);

    Travel updateTravel(Long accountId, Long travelId, TravelDto travelDto);
    Travel deleteTravel(Long accountId, Long travelId, boolean delete);

}
