package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.yata.common.constant.Code;
import project.yata.dto.JoinRequest;
import project.yata.dto.Response;
import project.yata.dto.TravelRequest;
import project.yata.service.YataService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/yata")
public class YataController {

    private YataService yataService;
    @PostMapping("/travel")
    public ResponseEntity<?> travel(@RequestBody TravelRequest travelRequest) {
        return new ResponseEntity<>(Response.builder().code(Code.SUCCESS.getCode())
                .data(yataService.travel(travelRequest)).build(), HttpStatus.OK);
    }

    @PostMapping("/travel")
    public ResponseEntity<?> travelInfo(@RequestHeader("ACCOUNT-ID") Long accountId) {
        return new ResponseEntity<>(yataService.travelInfo(accountId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Hello Yata", HttpStatus.OK);
    }

}
