package com.gcp.springboot.jamsession.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        // TODO: Implement exception catching instead of .get()
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        // TODO: Implement exception catching instead of .get()
        return new ResponseEntity<>(userService.getById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.create(user);
        // TODO: Implement exception catching instead of .get()
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
