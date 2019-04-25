package cs8.web.controller;

import cs8.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/dt")
@Slf4j
public class DudasTamasController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");
        return new User("Dudás Tamás", "d.tomi97@hotmail.com", LocalDateTime.now(), LocalDateTime.now());
    }


}
