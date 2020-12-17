package project.yata.service;

import project.yata.dto.PlanDto;
import project.yata.entity.Plan;

import java.util.List;

public interface PlanService {
     Plan plan(PlanDto planDto);

     List<Plan> planLists(Long accountId, Long travelId);
}
