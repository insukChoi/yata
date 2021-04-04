package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.*;
import project.yata.entity.Plan;
import project.yata.entity.Travel;
import project.yata.persistence.PlanRepository;
import project.yata.persistence.TravelRepository;
import project.yata.service.TravelService;

import java.util.List;
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
    public TravelDto getTravel(Long accountId, Long travelId) {
        return travelRepository.findByAccountIdAndId(accountId, travelId).orElseThrow(
                () -> new EmptyInfoException("There is no " + travelId + " travel plan.")
        ).toTravelDto();
    }

    @Override
    @Transactional
    public List<TravelDto> getTravels(Long accountId, int pageSize, int pageNumber) {
        return travelRepository.findByAccountId(accountId, PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(Travel::toTravelDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TravelResponse updateTravel(Long accountId, TravelUpdateRequest travelUpdateRequest) {
        Travel travel = travelRepository.findByAccountIdAndId(accountId, travelUpdateRequest.getId()).orElseThrow(
                () -> new EmptyInfoException("There is no " + travelUpdateRequest.getId() + " travel plan.")
        );
        travel.travelUpdate(travelUpdateRequest);
        return getTravelResponse(travel);
    }

    @Override
    @Transactional
    public TravelResponse deleteTravel(Long accountId, TravelDeleteRequest travelDeleteRequest) {
        Travel travel = travelRepository.findByAccountIdAndId(accountId, travelDeleteRequest.getId()).orElseThrow(
                () -> new EmptyInfoException("There is no " + travelDeleteRequest.getId() + " travel plan.")
        );
        travel.updateDelete(travelDeleteRequest.isDeleted());

        updateChildPlans(accountId, travelDeleteRequest, travel);

        return getTravelResponse(travel);
    }
}