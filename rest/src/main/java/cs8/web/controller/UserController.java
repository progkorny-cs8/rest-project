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
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        log.info("process=get-user-by-id, user_id={}", id);
        Optional<User> user = userService.getUserById(id);
        return user.map( u -> ResponseEntity.ok(u))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    @ResponseStatus(CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }
    

    @GetMapping("dt")
    public User getUser() {
        return new User("Dudás Tamás", "d.tomi97@hotmail.com", LocalDateTime.now(), LocalDateTime.now());
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

    @GetMapping("/szm")
    public User getUser() {
        return new User("Szabó Máté", "szabo.mate@inf.unideb.hu", LocalDateTime.now(), LocalDateTime.now());
    }

    @GetMapping("/print")
    public String print(){
        return "Szabó Máté-05-02-8:59";
    }

}
