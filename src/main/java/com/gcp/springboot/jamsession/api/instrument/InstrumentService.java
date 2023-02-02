package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstrumentService {
    @Autowired
    private InstrumentRepository instrumentRepository;
}
