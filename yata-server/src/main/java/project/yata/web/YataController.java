package project.yata.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import project.yata.config.security.JsonWebTokenProvider;
import project.yata.service.YataService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class YataController {

    @Description("")
    @GetMapping("")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>("Hello Yata", HttpStatus.OK);
    }

}
