package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.service.PlanService;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    @PostMapping("/plan")
    public ResponseEntity<Plan> plan(@RequestBody PlanDto planDto) {
        Plan savePlan = planService.plan(planDto);
        URI location= MvcUriComponentsBuilder
                .fromController(getClass()).path("/id")
                .buildAndExpand(savePlan.getTravelId()).toUri();
        // db에서 정보를 가져와서, travelId, accountId랑 비교해서 있으면 save하도록 code 추가

        return ResponseEntity.created(location).body(savePlan);
    }

    @GetMapping("/plan")
    public ResponseEntity<List<Plan>> planLists(@RequestParam("accountId") Long accountId,
                                                @RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(planService.planLists(accountId, travelId), HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanUpdateDto planUpdateDto) {
        return new ResponseEntity<>(planService.updatePlan(planUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanDeleteDto planDeleteDto) {
        return new ResponseEntity<>(planService.deletePlan(planDeleteDto), HttpStatus.OK);
    }
}
