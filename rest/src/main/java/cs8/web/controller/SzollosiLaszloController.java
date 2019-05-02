package cs8.web.controller;

import cs8.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/szl")
@Slf4j
public class SzollosiLaszloController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");
        return new User("Szöllősi László", "naintarlow@freemail.hu", LocalDateTime.now(), LocalDateTime.now());
    }


}
