package cs8.web.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs8.entity.User;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/ta")
@Slf4j
public class AttilaTorokController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");
        return new User("Török Attila", "torok.attila.alex@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }


}
