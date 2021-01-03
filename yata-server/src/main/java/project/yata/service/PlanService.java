package project.yata.service;

import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.entity.Travel;

import java.util.List;
import java.util.Set;

public interface PlanService {
     Plan plan(PlanDto planDto, Travel travel);

     List<Plan> planLists(Travel travel);

     Plan updatePlan(PlanUpdateDto planUpdateDto, Travel travel);

     Plan deletePlan(PlanDeleteDto planDeleteDto, Travel travel);
}
