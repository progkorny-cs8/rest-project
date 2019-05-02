package cs8.web.controller;

import cs8.entity.User;
import cs8.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("process=get-users");
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        log.info("process=get-user, user_id={}", id);
        Optional<User> user = userService.getUserById(id);
        return user.map( u -> ResponseEntity.ok(u))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    @ResponseStatus(CREATED)
    public User createUser(@RequestBody User user) {
        log.info("process=create-user, user_email={}", user.getEmail());
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        log.info("process=update-user, user_id={}", id);
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("process=delete-user, user_id={}", id);
        userService.deleteUser(id);
    }

    @GetMapping("/szl")
    public User getUser() {
        log.info("process=get-users");
        return new User("Szöllősi László", "naintarlow@freemail.hu", LocalDateTime.now(), LocalDateTime.now());
    }

    @GetMapping("/print")
    public String print(){
        System.out.println("Szőllősi László");
        return "Szőllősi László";

    }

}
