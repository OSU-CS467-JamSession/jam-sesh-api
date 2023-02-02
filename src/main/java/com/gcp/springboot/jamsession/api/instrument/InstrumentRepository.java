package com.gcp.springboot.jamsession.api.instrument;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    public Instrument findByName(String name);
    public List<Instrument> findByType(String type);
}
