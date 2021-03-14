package project.yata.service;

import project.yata.dto.PlanDeleteRequest;
import project.yata.dto.PlanRequest;
import project.yata.dto.PlanResponse;
import project.yata.dto.PlanUpdateRequest;
import project.yata.entity.Plan;

import java.util.Set;

public interface PlanService {
     Plan savePlan(Long accountId, PlanRequest planRequest);

     Set<Plan> getPlanList(Long accountId, Long travelId);

     Plan updatePlan(Long accountId, PlanUpdateRequest planUpdateRequest);

     Plan deletePlan(Long accountId, PlanDeleteRequest planDeleteRequest);
}
