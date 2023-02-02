package com.gcp.springboot.jamsession.api.instrument;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    public Optional<Instrument> findByName(String name);
}
