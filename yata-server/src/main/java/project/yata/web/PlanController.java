package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import project.yata.dto.PlanDto;
import project.yata.entity.Plan;
import project.yata.service.PlanService;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    @PostMapping("/plan")
    public ResponseEntity<Plan> plan(@RequestBody PlanDto planDto)
    {
        Plan savePlan = planService.plan(planDto);
        URI location= MvcUriComponentsBuilder
                .fromController(getClass()).path("/id")
                .buildAndExpand(savePlan.getTravelId()).toUri();
        return ResponseEntity.created(location).body(savePlan);

    }
}
