package com.gcp.springboot.jamsession.api.status;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StatusController {
    @RequestMapping("status")
    public String tellStatus(){
        return "We are up!";
    }
}
