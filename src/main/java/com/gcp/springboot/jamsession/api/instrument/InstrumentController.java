package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gcp.springboot.jamsession.api.user.User;
import com.gcp.springboot.jamsession.api.user.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;
}
