package cs8.web.controller;

import cs8.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/ol")
@Slf4j
public class OlahLajosController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");
        return new User("Oláh Lajos", "olalika98@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }

}
