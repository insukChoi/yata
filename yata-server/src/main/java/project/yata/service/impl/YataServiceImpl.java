package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.dto.TravelDto;
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
        //DB에 저장하고, 저장된 객체로 return

        return travelRepository.save(travel);
    }

    @Override
    public Travel travelInfo(Long accountId) {
        return travelRepository.findByAccountId(accountId);
    }
}
