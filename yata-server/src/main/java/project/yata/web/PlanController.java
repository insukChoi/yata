package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import project.yata.common.error.exception.EmptyInfoException;
import project.yata.dto.PlanDeleteDto;
import project.yata.dto.PlanDto;
import project.yata.dto.PlanUpdateDto;
import project.yata.entity.Plan;
import project.yata.entity.Travel;
import project.yata.service.PlanService;
import project.yata.service.TravelService;

import java.net.URI;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanController {
    private final PlanService planService;
    private final TravelService travelService;

    public Travel findTravel(Long accountId, Long travelId)
    {
        Travel findTravel = travelService.travelInfo(accountId, travelId);

        if(findTravel == null)
            throw new EmptyInfoException("There is not suitable Travel information");
        return findTravel;
    }
    @PostMapping("/plan")
    public ResponseEntity<Plan> plan(@RequestBody PlanDto planDto) {


        Plan savePlan = planService.plan(planDto, findTravel(planDto.getAccountId(), planDto.getTravelId()));
        URI location= MvcUriComponentsBuilder
                .fromController(getClass()).path("/id")
                .buildAndExpand(savePlan.getTravel().getId()).toUri();

        return ResponseEntity.created(location).body(savePlan);
    }

    @GetMapping("/plan")
    public ResponseEntity<List<Plan>> planLists(@RequestParam("accountId") Long accountId,
                                               @RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(planService.planLists(findTravel(accountId, travelId)), HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanUpdateDto planUpdateDto) {
        return new ResponseEntity<>(planService.updatePlan(planUpdateDto,
                findTravel(planUpdateDto.getAccountId(), planUpdateDto.getTravelId()) ), HttpStatus.OK);
    }

    @DeleteMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanDeleteDto planDeleteDto) {
        return new ResponseEntity<>(planService.deletePlan(planDeleteDto,
                findTravel(planDeleteDto.getAccountId(), planDeleteDto.getTravelId())), HttpStatus.OK);
    }
}
