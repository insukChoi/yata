package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.dto.TravelRequest;
import project.yata.entity.Account;
import project.yata.entity.Travel;
import project.yata.persistence.AccountRepository;
import project.yata.persistence.TravelRepository;
import project.yata.service.YataService;

import java.util.List;

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
    public Long travel(TravelRequest travelRequest) {
        Travel travel = Travel.builder()
                .accountId(travelRequest.getAccountId())
                .title(travelRequest.getTitle())
                .memo(travelRequest.getMemo())
                .place(travelRequest.getPlace())
                .timeDiff(travelRequest.getTimeDiff())
                .endDate(travelRequest.getEndDate())
                .startDate(travelRequest.getStartDate())
                .build();

        return travel.getAccountId();
    }

    @Override
    public TravelRequest travelInfo(Long accountId) {
        Travel travel = travelRepository.findByAccountId(accountId);
        return null;
    }
}
