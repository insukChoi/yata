package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.PlanDeleteRequest;
import project.yata.dto.PlanRequest;
import project.yata.dto.PlanResponse;
import project.yata.dto.PlanUpdateRequest;
import project.yata.entity.Plan;
import project.yata.entity.Travel;
import project.yata.persistence.PlanRepository;
import project.yata.persistence.TravelRepository;
import project.yata.service.PlanService;

import java.util.Set;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;
    private final TravelRepository travelRepository;

    private Travel findTravel(Long accountId, Long travelId)
    {
        Travel findTravel = travelRepository.findByAccountIdAndId(accountId, travelId);

        if(findTravel == null)
            throw new EmptyInfoException("There is not suitable Travel information");
        return findTravel;
    }

    private Plan planInfo(Long id, Travel travel){
        Plan plan = planRepository.findPlanByIdAndTravel(id, travel);
        if(plan == null)
            throw new EmptyInfoException("There is no suitable information in plans");
        return plan;
    }

    @Override
    @Transactional
    public Plan plan(Long accountId, PlanRequest planRequest) {
        Plan plan = Plan.builder()
                .linkTo(planRequest.getLinkTo())
                .memo(planRequest.getMemo())
                .time(planRequest.getTime())
                .build();

        plan.setTravel(findTravel(accountId, planRequest.getTravelId()));

        return planRepository.save(plan);
    }

    @Override
    public PlanResponse getPlanResponse(Plan plan)
    {
        return PlanResponse.builder()
                .id(plan.getId())
                .linkTo(plan.getLinkTo())
                .time(plan.getTime())
                .memo(plan.getMemo())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Plan> planLists(Long accountId, Long travelId) {
        Travel travel = findTravel(accountId, travelId);
        if(travel == null)
            throw new EmptyInfoException("There is no plan");
         return planRepository.findAllByTravel(travel);
    }

    @Override
    @Transactional
    public Plan updatePlan(Long accountId, PlanUpdateRequest planUpdateRequest) {
        Travel travel = findTravel(accountId, planUpdateRequest.getTravelId());
        Plan plan = planInfo(planUpdateRequest.getId(), travel);
        plan.planUpdate(planUpdateRequest);
        return planRepository.save(plan);
    }

    @Override
    @Transactional
    public Plan deletePlan(Long accountId, PlanDeleteRequest planDeleteRequest) {
        Travel travel = findTravel(accountId, planDeleteRequest.getTravelId());
        Plan plan = planInfo(planDeleteRequest.getId(), travel);
        plan.updateDelete(planDeleteRequest.isDeleted());
        return planRepository.save(plan);
    }
}
