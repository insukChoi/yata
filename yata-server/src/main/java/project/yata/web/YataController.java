package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.common.constant.Code;
import project.yata.dto.Response;
import project.yata.dto.TravelDto;
import project.yata.entity.Travel;
import project.yata.service.YataService;

@Slf4j
@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v2/yata")
public class YataController {

    private final YataService yataService;

    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Hello Yata", HttpStatus.OK);
    }

    @PostMapping("/travel")
    public ResponseEntity<?> travel(@RequestBody TravelDto travelDto) {
        return new ResponseEntity<>(Response.builder().code(Code.SUCCESS.getCode())
                .data(yataService.travel(travelDto)).build(), HttpStatus.OK);
    }
    @GetMapping("/travels")
    public ResponseEntity<?> travelInfos(@RequestHeader("ACCOUNT-ID") Long accountId) {
        return new ResponseEntity<>(yataService.travelInfos(accountId), HttpStatus.OK);
    }

    @GetMapping("/travel/{travelId}")
    public ResponseEntity<?> travelInfos(@RequestHeader("ACCOUNT-ID") Long accountId,
                                         @PathVariable Long travelId) {
        return new ResponseEntity<>(yataService.travelInfo(accountId, travelId), HttpStatus.OK);
    }

    @PutMapping("/travel/{travelId}")
    public ResponseEntity travelUpdate(@RequestHeader("ACCOUNT-ID") Long accountId,
                                       @PathVariable Long travelId,
                                       @RequestBody TravelDto travelDto){
        return new ResponseEntity<>(yataService.travelUpdate(accountId, travelId, travelDto), HttpStatus.OK);
    }
    @PutMapping("/travel/delete/{travelId}")
    public ResponseEntity travelUpdate(@RequestHeader("ACCOUNT-ID") Long accountId,
                                       @PathVariable Long travelId,
                                       @RequestBody boolean delete){
        return new ResponseEntity<>(yataService.travelDelete(accountId, travelId, delete), HttpStatus.OK);
    }
}
