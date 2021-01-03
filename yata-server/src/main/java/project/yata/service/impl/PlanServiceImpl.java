package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.entity.Travel;
import project.yata.persistence.PlanRepository;
import project.yata.service.PlanService;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
//    private final AccountRepository accountRepository;
    private final PlanRepository planRepository;

    @Override
    public Plan plan(PlanDto planDto, Travel travel)
    {
        Plan plan = Plan.builder()
                .linkTo(planDto.getLinkTo())
                .memo(planDto.getMemo())
                .time(planDto.getTime())
                .build();

        plan.setTravel(travel);
        return planRepository.save(plan);
    }

    @Override
    public List<Plan> planLists(Travel travel) {
        System.out.println(planRepository.countAllByTravel(travel));
         if(planRepository.findAllByTravel(travel).isEmpty())
             throw new EmptyInfoException("There is no plan");
         return planRepository.findAllByTravel(travel);
    }


    public Plan planInfo(Long id, Travel travel){
        Plan plan = planRepository.findPlanByIdAndTravel(id, travel);
        if(plan == null)
            throw new EmptyInfoException("There is no suitable information in plans");
        return plan;
    }

    @Override
    public Plan updatePlan(PlanUpdateDto planUpdateDto, Travel travel) {
        Plan plan = planInfo(planUpdateDto.getId(), travel);
        plan.planUpdate(planUpdateDto);
        return planRepository.save(plan);
    }

    @Override
    public Plan deletePlan(PlanDeleteDto planDeleteDto, Travel travel) {
        Plan plan = planInfo(planDeleteDto.getId(), travel);
        plan.updateDelete(planDeleteDto.isDeleted());
        return planRepository.save(plan);
    }
}
