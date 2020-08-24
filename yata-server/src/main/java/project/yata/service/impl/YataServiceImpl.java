package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.TravelDto;
import project.yata.entity.Account;
import project.yata.entity.Travel;
import project.yata.persistence.AccountRepository;
import project.yata.persistence.TravelRepository;
import project.yata.service.YataService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class YataServiceImpl implements YataService {

    private final AccountRepository accountRepository;
    private final TravelRepository travelRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    //Travel 등록
    public Travel travel(TravelDto travelDto) {
        Travel travel = Travel.builder()
                .accountId(travelDto.getAccountId())
                .title(travelDto.getTitle())
                .memo(travelDto.getMemo())
                .place(travelDto.getPlace())
                .timeDiff(travelDto.getTimeDiff())
                .endDate(travelDto.getEndDate())
                .startDate(travelDto.getStartDate())
                .build();

        return travelRepository.save(travel);
    }

    @Override
    public Travel travelInfo(Long accountId, Long travelId) {
        Travel travel = travelRepository.findByAccountIdAndId(accountId, travelId);
        if(travel == null)
            throw new EmptyInfoException("There is no plan " + travelId + " travel.");
        return travel;
    }

    @Override
    public List<Travel> travelInfos(Long accountId) {
        List<Travel> travel = travelRepository.findByAccountId(accountId);
        if(travel.isEmpty())
            throw new EmptyInfoException("There is no travel plan.");
        return travel;
    }

    @Override
    public Travel updateTravel(Long accountId, Long travelId, TravelDto travelDto) {
        Travel travel = travelRepository.findByAccountIdAndId(accountId, travelId);
        if(travelDto != null) {
            travel.travelUpdate(travelDto);
            travelRepository.save(travel);
        }
        return travel;
    }

    @Override
    public Travel deleteTravel(Long accountId, Long travelId, boolean delete) {
        Travel travel = travelRepository.findByAccountIdAndId(accountId, travelId);
        travel.updateDelete(delete);

        return travelRepository.save(travel);
    }
}
