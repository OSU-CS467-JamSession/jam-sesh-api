package com.gcp.springboot.jamsession.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/user/{userID}")
    public void deleteUser(@PathVariable long userID) {
        userService.deleteUser(userID);
    }
}
