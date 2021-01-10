package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanController {
    private final PlanService planService;
    private final TravelService travelService;

    private Travel findTravel(Long accountId, Long travelId)
    {
        Travel findTravel = travelService.travelInfo(accountId, travelId);

        if(findTravel == null)
            throw new EmptyInfoException("There is not suitable Travel information");
        return findTravel;
    }

    @PostMapping("/plan")
    @Transactional
    public ResponseEntity<Plan> plan(@RequestBody PlanDto planDto) {
        final Plan savePlan = planService.plan(planDto, findTravel(planDto.getAccountId(), planDto.getTravelId()));
        return ResponseEntity
                .created(URI.create(String.format("/plan/%d/%d/%d", savePlan.getTravel().getAccountId(), savePlan.getTravel().getId(), savePlan.getId())))
                .body(savePlan);
    }

    @GetMapping("/plan")
    @Transactional
    public ResponseEntity<Set<Plan>> planLists(@RequestParam("accountId") Long accountId,
                                                @RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(planService.planLists(findTravel(accountId, travelId)), HttpStatus.OK);
    }

    @PutMapping("/plan")
    @Transactional
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanUpdateDto planUpdateDto) {
        return new ResponseEntity<>(planService.updatePlan(planUpdateDto,
                findTravel(planUpdateDto.getAccountId(), planUpdateDto.getTravelId()) ), HttpStatus.OK);
    }

    @DeleteMapping("/plan")
    @Transactional
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanDeleteDto planDeleteDto) {
        return new ResponseEntity<>(planService.deletePlan(planDeleteDto,
                findTravel(planDeleteDto.getAccountId(), planDeleteDto.getTravelId())), HttpStatus.OK);
    }
}
