package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.persistence.PlanRepository;
import project.yata.service.PlanService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
//    private final AccountRepository accountRepository;
    private final PlanRepository planRepository;

    @Override
    public Plan plan(PlanDto planDto)
    {
        if(planRepository.findByAccountIdAndTravelId(planDto.getAccountId(), planDto.getTravelId()) == null)
            throw new EmptyInfoException("There is no travel information");

        Plan plan = Plan.builder()
                .accountId(planDto.getAccountId())
                .travelId(planDto.getTravelId())
                .linkTo(planDto.getLinkTo())
                .memo(planDto.getMemo())
                .time(planDto.getTime())
                .build();

        return planRepository.save(plan);
    }

    @Override
    public List<Plan> planLists(Long accountId, Long travelId) {
        int cnt = planRepository.countPlansByAccountIdAndTravelId(accountId, travelId);
        if(cnt == 0)
            throw new EmptyInfoException("There is no plan yet");

        return planRepository.findPlansByAccountIdAndTravelId(accountId, travelId);
    }

    public Plan planInfo(Long id, Long accountId, Long travelId){
        Plan plan = planRepository.findPlanByIdAndAccountIdAndTravelId(
                id, accountId, travelId);
        if(plan == null)
            throw new EmptyInfoException("There is no suitable information in plans");
        return plan;
    }
    @Override
    public Plan updatePlan(PlanUpdateDto planUpdateDto) {
        Plan plan = planInfo(planUpdateDto.getId(), planUpdateDto.getAccountId(),
                planUpdateDto.getTravelId());
        plan.planUpdate(planUpdateDto);
        return planRepository.save(plan);
    }

    @Override
    public Plan deletePlan(PlanDeleteDto planDeleteDto) {
        Plan plan = planInfo(planDeleteDto.getId(), planDeleteDto.getAccountId(),
                planDeleteDto.getTravelId());
        plan.updateDelete(planDeleteDto.isDeleted());
        return planRepository.save(plan);
    }


}
