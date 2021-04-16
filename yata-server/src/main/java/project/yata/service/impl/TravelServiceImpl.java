package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;
    private final PlanRepository planRepository;
    private final PlanServiceImpl planService;

    private TravelResponse getTravelResponse(Travel travel) {
        System.out.println("kyuli====================0");
        return TravelResponse.builder()
                .id(travel.getId())
                .accountId(travel.getAccountId())
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
        List<Plan> plans = planRepository.findAllByTravel(travel);
        for (Plan p : plans) {
            planService.deletePlan(accountId, new PlanDeleteRequest(p.getId(), travelDeleteRequest.getId(), travelDeleteRequest.isDeleted()));
        }
    }

    private Travel findTravel(Long accountId, Long travelId) {
        return travelRepository.findByAccountIdAndId(accountId, travelId).orElseThrow(
                () -> new EmptyInfoException("There is no " + travelId + "travel information.")
        );
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
    public TravelResponse getTravel(Long accountId, Long travelId) {
        Travel travel = findTravel(accountId, travelId);
        return getTravelResponse(travel);
    }

    @Override
    @Transactional
    public List<TravelResponse> getTravelList(Long accountId, int offset, int count) {
        return travelRepository.findByAccountId(accountId, PageRequest.of(offset, count))
                .stream()
                .map(Travel::toTravelResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TravelResponse updateTravel(Long accountId, TravelUpdateRequest travelUpdateRequest) {
        Travel travel = findTravel(accountId, travelUpdateRequest.getId());
        travel.travelUpdate(travelUpdateRequest);
        travelRepository.save(travel);

        return TravelResponse.builder()
                .id(travel.getId())
                .accountId(travel.getAccountId())
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

    @Override
    @Transactional
    public TravelResponse deleteTravel(Long accountId, TravelDeleteRequest travelDeleteRequest) {
        Travel travel = findTravel(accountId, travelDeleteRequest.getId());
        travel.updateDelete(travelDeleteRequest.isDeleted());

        updateChildPlans(accountId, travelDeleteRequest, travel);

        travelRepository.save(travel);
        return getTravelResponse(travel);
    }
}