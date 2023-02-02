package com.gcp.springboot.jamsession.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/logins")
    public List<Login> getLogins() {
        return loginService.getLogins();
    }

}
