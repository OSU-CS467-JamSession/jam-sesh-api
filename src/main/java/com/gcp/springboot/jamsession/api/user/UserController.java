package com.gcp.springboot.jamsession.api.user;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@Controller
public class UserController {

    public static class LoginDto {
        public String email;
        public String password;
    }
    
    @Autowired
    private UserRepository userRepo;

    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> checkLogin(
            @RequestBody LoginDto creds) {

        User user = userRepo.findByEmail(creds.email);
        System.out.println(creds.password);
        System.out.println(creds.email);

        if(user == null){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        else {
            if(creds.password.equals(user.getLogin().getSaltedPass())) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
            }
        }
    }
}
