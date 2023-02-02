package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;
}
