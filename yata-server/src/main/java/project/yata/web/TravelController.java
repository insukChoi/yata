package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import project.yata.dto.TravelDeleteDto;
import project.yata.dto.TravelDto;
import project.yata.dto.TravelUpdateDto;
import project.yata.entity.Travel;
import project.yata.service.TravelService;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TravelController {

    private final TravelService travelService;

    @PostMapping("/travel")
    public ResponseEntity<Travel> travel(@RequestBody TravelDto travelDto) {
        Travel saveTravel = travelService.travel(travelDto);
        URI location = MvcUriComponentsBuilder
                .fromController(getClass()).path("/id")
                .buildAndExpand(saveTravel.getAccountId()).toUri();

        return ResponseEntity.created(location).body(saveTravel);
    }

    @GetMapping("/travels")
    public ResponseEntity<List<Travel>> travelInfos(@RequestParam("accountId") Long accountId,
                                                    @RequestParam("offset") int offset,
                                                    @RequestParam("count") int count) {
        return new ResponseEntity<>(travelService.travelInfos(accountId, offset, count), HttpStatus.OK);
    }


    @GetMapping("/travel")
    public ResponseEntity<Travel> travelInfos(@RequestParam("accountId") Long accountId,
                                              @RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(travelService.travelInfo(accountId, travelId), HttpStatus.OK);
    }

    @PutMapping("/travel")
    public ResponseEntity<Travel> updateTravel(@RequestBody TravelUpdateDto travelUpdateDto) {
        return new ResponseEntity<>(travelService.updateTravel(travelUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/travel")
    public ResponseEntity<Travel> updateTravel(@RequestBody TravelDeleteDto travelDeleteDto) {
        return new ResponseEntity<>(travelService.deleteTravel(travelDeleteDto), HttpStatus.OK);
    }
}