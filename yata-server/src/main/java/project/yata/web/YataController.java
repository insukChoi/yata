package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.yata.service.YataService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class YataController {

    private final YataService yataService;

    @GetMapping("/index")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Hello Yata", HttpStatus.OK);
    }

}
