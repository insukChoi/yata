package project.yata.service;

import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.entity.Travel;

import java.util.Set;

import java.util.Optional;

public interface PlanService {


     Plan plan(PlanDto planDto);

     Set<Plan> planLists(Long accountId, Long travelId);

     Plan updatePlan(PlanUpdateDto planUpdateDto);

     Plan deletePlan(PlanDeleteDto planDeleteDto);
}
