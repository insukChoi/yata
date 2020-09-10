package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.TravelDeleteDto;
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
        Optional<Travel> travel = Optional.ofNullable(
                travelRepository.findByAccountIdAndId(accountId, travelId));
        return travel.orElseThrow(()
                -> new EmptyInfoException("There is no " + travelId + " travel plan."));
    }

    @Override
    public List<Travel> travelInfos(Long accountId, int offset, int count) {
        List<Travel> travel = travelRepository.findByAccountId(accountId);
        if (travel.isEmpty())
            throw new EmptyInfoException("There is no travel plan.");
        return travel.subList(offset, count);
    }

    @Override
    public Travel updateTravel(Long travelId, TravelDto travelDto) {
        System.out.println(travelDto.getAccountId() + " " + travelId);
        Travel travel = travelInfo(travelDto.getAccountId(), travelId);
        travel.travelUpdate(travelDto);
        return travelRepository.save(travel);
    }

    @Override
    public Travel deleteTravel(TravelDeleteDto travelDeleteDto) {
        Travel travel = travelInfo(travelDeleteDto.getAccountId(), travelDeleteDto.getId());
        travel.updateDelete(travelDeleteDto.isDelete());
        return travelRepository.save(travel);
    }
}
