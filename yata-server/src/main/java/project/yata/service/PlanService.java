package project.yata.service;

import project.yata.dto.PlanDto;
import project.yata.entity.Plan;

public interface PlanService {
     Plan plan(PlanDto planDto);
}
