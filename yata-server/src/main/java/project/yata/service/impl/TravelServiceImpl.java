package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.*;
import project.yata.entity.Account;
import project.yata.entity.Plan;
import project.yata.entity.Travel;
import project.yata.persistence.AccountRepository;
import project.yata.persistence.PlanRepository;
import project.yata.persistence.TravelRepository;
import project.yata.service.TravelService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
    private final AccountRepository accountRepository;
    private final TravelRepository travelRepository;
    private final PlanRepository planRepository;
    private final PlanServiceImpl planService;

    private TravelResponse getTravelResponse(Travel travel) {
        return TravelResponse.builder()
            .id(travel.getId())
            .title(travel.getTitle())
            .endDate(travel.getEndDate())
            .memo(travel.getMemo())
            .place(travel.getPlace())
            .startDate(travel.getStartDate())
            .timeDiff(travel.getTimeDiff())
            .isDeleted(travel.isDeleted())
            .plans(travel.getPlans())
            .build();
    }

    private void updateChildPlans(Long accountId, TravelDeleteRequest travelDeleteRequest, Travel travel) {
        Set<Plan> plans = planRepository.findAllByTravel(travel);

        for (Plan p : plans) {
            planService.deletePlan(accountId, new PlanDeleteRequest(p.getId(), travelDeleteRequest.getId(), travelDeleteRequest.isDeleted()));
        }
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public TravelResponse saveTravel(Long accountId, TravelRequest travelRequest) {
        Travel travel = Travel.builder()
            .accountId(accountId)
            .title(travelRequest.getTitle())
            .memo(travelRequest.getMemo())
            .place(travelRequest.getPlace())
            .timeDiff(travelRequest.getTimeDiff())
            .endDate(travelRequest.getEndDate())
            .startDate(travelRequest.getStartDate())
            .build();

        travelRepository.save(travel);
        return getTravelResponse(travel);
    }

    @Override
    @Transactional
    public Travel getTravel(Long accountId, Long travelId) {
        Optional<Travel> travel = Optional.ofNullable(
            travelRepository.findByAccountIdAndId(accountId, travelId));
        return travel.orElseThrow(()
            -> new EmptyInfoException("There is no " + travelId + " travel plan."));
    }

    @Override
    @Transactional
    public List<Travel> getTravelList(Long accountId, int offset, int count) {
        int cnt = travelRepository.countByAccountId(accountId);
        if (cnt == 0)
            throw new EmptyInfoException("There is no travel plan.");

        List<Travel> travel = travelRepository.findByAccountId(accountId);
        if (cnt < count)
            return travel.subList(offset, cnt);
        return travel.subList(offset, count);
    }

    @Override
    @Transactional
    public TravelResponse updateTravel(Long accountId, TravelUpdateRequest travelUpdateRequest) {
        Travel travel = getTravel(accountId, travelUpdateRequest.getId());
        travel.travelUpdate(travelUpdateRequest);
        travelRepository.save(travel);
        return getTravelResponse(travel);
    }

    @Override
    @Transactional
    public TravelResponse deleteTravel(Long accountId, TravelDeleteRequest travelDeleteRequest) {
        Travel travel = getTravel(accountId, travelDeleteRequest.getId());
        travel.updateDelete(travelDeleteRequest.isDeleted());

        updateChildPlans(accountId, travelDeleteRequest, travel);

        travelRepository.save(travel);
        return getTravelResponse(travel);
    }
}