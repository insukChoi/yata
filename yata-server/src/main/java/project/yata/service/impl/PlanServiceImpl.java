package project.yata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.yata.dto.PlanDto;
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
        Plan plan = Plan.builder()
                .travelId(planDto.getTravelId())
                .linkTo(planDto.getLinkTo())
                .memo(planDto.getMemo())
                .time(planDto.getTime())
                .build();

        return planRepository.save(plan);
    }

    @Override
    public List<Plan> planLists(Long accountId, Long travelId) {
        List<Plan> plans = planRepository.findByTravelId(travelId);
        return plans;
    }

}
