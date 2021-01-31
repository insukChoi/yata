package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.dto.*;
import project.yata.entity.Plan;
import project.yata.service.PlanService;

import java.net.URI;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanController {
    private final PlanService planService;

    @PostMapping("/plan")
    public ResponseEntity<ApiResponse> plan(@RequestBody PlanRequest planRequest) {
        final Plan savePlan = planService.plan(planRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, "/plan/" + savePlan.getId())
                .body(
                        ApiResponse.success(
                                planService.getPlan(savePlan)
                        )
                );
    }

    @GetMapping("/plan")
    public ResponseEntity<Set<Plan>> planLists(@RequestParam("accountId") Long accountId,
                                                @RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(planService.planLists(accountId, travelId), HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanUpdateRequest planUpdateRequest) {
        return new ResponseEntity<>(planService.updatePlan(planUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanDeleteRequest planDeleteRequest) {
        return new ResponseEntity<>(planService.deletePlan(planDeleteRequest), HttpStatus.OK);
    }
}
