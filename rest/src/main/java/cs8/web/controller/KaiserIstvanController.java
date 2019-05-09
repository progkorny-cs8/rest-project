package cs8.web.controller;

import cs8.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ki")
@Slf4j

public class KaiserIstvanController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");
        return new User("Kaiser István", "kaiseristvan96@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }
}
