package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.config.security.JwtProvider;
import project.yata.dto.*;
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
        final TravelResponse saveTravel = travelService.saveTravel(jwtProvider.getAccountId(), travelRequest);

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
    public ResponseEntity<List<TravelResponse>> travelInfos(@RequestParam("offset") int offset,
                                                            @RequestParam("count") int count) {
        return new ResponseEntity<>(travelService.getTravelList(jwtProvider.getAccountId(), offset, count), HttpStatus.OK);
    }


    @GetMapping("/travel")
    public ResponseEntity<TravelResponse> travelInfos(@RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(travelService.getTravel(jwtProvider.getAccountId(), travelId), HttpStatus.OK);
    }

    @PutMapping("/travel")
    public ResponseEntity<TravelResponse> updateTravel(@RequestBody TravelUpdateRequest travelUpdateRequest) {
        return new ResponseEntity<>(travelService.updateTravel(jwtProvider.getAccountId(), travelUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/travel")
    public ResponseEntity<TravelResponse> updateTravel(@RequestBody TravelDeleteRequest travelDeleteRequest) {
        return new ResponseEntity<>(travelService.deleteTravel(jwtProvider.getAccountId(), travelDeleteRequest), HttpStatus.OK);
    }
}