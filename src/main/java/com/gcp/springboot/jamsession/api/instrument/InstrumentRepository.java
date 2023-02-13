package com.gcp.springboot.jamsession.api.instrument;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    public Instrument findByName(String name);
    public List<Instrument> findByType(String type);
}
