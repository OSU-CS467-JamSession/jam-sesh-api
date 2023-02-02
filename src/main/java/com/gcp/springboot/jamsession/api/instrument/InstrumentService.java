package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {
    @Autowired
    private InstrumentRepository instrumentRepository;
}
