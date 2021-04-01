package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.config.security.JwtProvider;
import project.yata.dto.*;
import project.yata.entity.Plan;
import project.yata.service.PlanService;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanController {
    private final PlanService planService;
    private final JwtProvider jwtProvider;

    @PostMapping("/plan")
    public ResponseEntity<ApiResponse> plan(@RequestBody PlanRequest planRequest) {
        final PlanResponse savePlan = planService.savePlan(jwtProvider.getAccountId(), planRequest);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header(HttpHeaders.LOCATION, "/plan/" + savePlan.getId())
            .body(
                ApiResponse.success(
                    savePlan
                )
            );
    }

    @GetMapping("/plan")
    public ResponseEntity<Set<Plan>> planLists(@RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(planService.getPlanList(jwtProvider.getAccountId(), travelId), HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<PlanResponse> updatePlan(@RequestBody PlanUpdateRequest planUpdateRequest) {
        return new ResponseEntity<>(planService.updatePlan(jwtProvider.getAccountId(), planUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody PlanDeleteRequest planDeleteRequest) {
        return new ResponseEntity<>(planService.deletePlan(jwtProvider.getAccountId(), planDeleteRequest), HttpStatus.OK);
    }
}
