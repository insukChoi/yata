package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.config.security.JwtProvider;
import project.yata.dto.ApiResponse;
import project.yata.dto.TravelDeleteRequest;
import project.yata.dto.TravelRequest;
import project.yata.dto.TravelUpdateRequest;
import project.yata.entity.Travel;
import project.yata.service.TravelService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController("/api")
public class TravelController {

    private final TravelService travelService;
    private final JwtProvider jwtProvider;

    @PostMapping("/travel")
    public ResponseEntity<ApiResponse> travel(@RequestBody TravelRequest travelRequest) {
        final Travel saveTravel = travelService.saveTravel(jwtProvider.getAccountId(), travelRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, "/travel/" + saveTravel.getId())
                .body(
                        ApiResponse.success(
                                saveTravel
                        )
                );
    }

    @GetMapping("/travels")
    public ResponseEntity<List<Travel>> travelInfos(@RequestParam("offset") int offset,
                                                    @RequestParam("count") int count) {
        return new ResponseEntity<>(travelService.getTravelList(jwtProvider.getAccountId(), offset, count), HttpStatus.OK);
    }


    @GetMapping("/travel")
    public ResponseEntity<Travel> travelInfos(@RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(travelService.getTravel(jwtProvider.getAccountId(), travelId), HttpStatus.OK);
    }

    @PutMapping("/travel")
    public ResponseEntity<Travel> updateTravel(@RequestBody TravelUpdateRequest travelUpdateRequest) {
        return new ResponseEntity<>(travelService.updateTravel(jwtProvider.getAccountId(), travelUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/travel")
    public ResponseEntity<Travel> updateTravel(@RequestBody TravelDeleteRequest travelDeleteRequest) {
        return new ResponseEntity<>(travelService.deleteTravel(jwtProvider.getAccountId(), travelDeleteRequest), HttpStatus.OK);
    }
}