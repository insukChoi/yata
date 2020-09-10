package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.dto.TravelDeleteDto;
import project.yata.dto.TravelDto;
import project.yata.entity.Travel;
import project.yata.service.YataService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class YataController {

    private final YataService yataService;

    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Hello Yata", HttpStatus.OK);
    }

    @PostMapping("/travel")
    public ResponseEntity<Travel> travel(@RequestBody TravelDto travelDto) {
//        return new ResponseEntity<>(Response.builder().code(Code.SUCCESS.getCode())
//                .data(yataService.travel(travelDto)).build(), HttpStatus.OK);
        return new ResponseEntity<>(yataService.travel(travelDto), HttpStatus.CREATED);
    }

    @GetMapping("/travels")
    public ResponseEntity<List<Travel>> travelInfos(@RequestParam("accountId") Long accountId,
                                                    @RequestParam("offset") int offset,
                                                    @RequestParam("count") int count) {
        return new ResponseEntity<>(yataService.travelInfos(accountId, offset, count), HttpStatus.OK);
    }


    @GetMapping("/travel")
    public ResponseEntity<Travel> travelInfos(@RequestParam("accountId") Long accountId,
                                              @RequestParam("travelId") Long travelId) {
        return new ResponseEntity<>(yataService.travelInfo(accountId, travelId), HttpStatus.OK);
    }

    @PutMapping("/travel/{travelId}")
    public ResponseEntity<Travel> travelUpdate(@PathVariable Long travelId,TravelDto travelDto) {
        return new ResponseEntity<>(yataService.updateTravel(travelId, travelDto), HttpStatus.OK);
    }

    @DeleteMapping("/travel")
    public ResponseEntity<Travel> travelUpdate(TravelDeleteDto travelDeleteDto) {
        return new ResponseEntity<>(yataService.deleteTravel(travelDeleteDto), HttpStatus.OK);
    }
}
