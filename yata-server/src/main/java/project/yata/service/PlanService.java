package project.yata.service;

import project.yata.dto.PlanDeleteRequest;
import project.yata.dto.PlanRequest;
import project.yata.dto.PlanResponse;
import project.yata.dto.PlanUpdateRequest;
import project.yata.entity.Plan;

import java.util.Set;

public interface PlanService {
     PlanResponse savePlan(Long accountId, PlanRequest planRequest);

     Set<Plan> getPlanList(Long accountId, Long travelId);

     PlanResponse updatePlan(Long accountId, PlanUpdateRequest planUpdateRequest);

     PlanResponse deletePlan(Long accountId, PlanDeleteRequest planDeleteRequest);
}
