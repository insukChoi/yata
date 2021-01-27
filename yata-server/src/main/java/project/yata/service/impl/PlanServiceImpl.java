package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.entity.Travel;
import project.yata.persistence.PlanRepository;
import project.yata.persistence.TravelRepository;
import project.yata.service.PlanService;

import java.util.List;
import java.util.Optional;
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
    public Plan plan(PlanDto planDto) {
        Plan plan = Plan.builder()
                .linkTo(planDto.getLinkTo())
                .memo(planDto.getMemo())
                .time(planDto.getTime())
                .build();

        plan.setTravel(findTravel(planDto.getAccountId(), planDto.getTravelId()));
        return planRepository.save(plan);
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
    public Plan updatePlan(PlanUpdateDto planUpdateDto) {
        Travel travel = findTravel(planUpdateDto.getAccountId(), planUpdateDto.getTravelId());
        Plan plan = planInfo(planUpdateDto.getId(), travel);
        plan.planUpdate(planUpdateDto);
        return planRepository.save(plan);
    }

    @Override
    public Plan deletePlan(PlanDeleteDto planDeleteDto) {
        Travel travel = findTravel(planDeleteDto.getAccountId(), planDeleteDto.getTravelId());
        Plan plan = planInfo(planDeleteDto.getId(), travel);
        plan.updateDelete(planDeleteDto.isDeleted());
        return planRepository.save(plan);
    }
}
