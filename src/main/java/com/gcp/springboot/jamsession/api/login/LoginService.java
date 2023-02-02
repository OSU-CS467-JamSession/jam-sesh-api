package com.gcp.springboot.jamsession.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getLogins() {
        List<Login> logins = new ArrayList<>();
        loginRepository.findAll()
                .forEach(logins::add);
        return logins;
    }
}
