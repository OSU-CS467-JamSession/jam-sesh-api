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

    public List<Instrument> getAll() {
        List<Instrument> instruments = new ArrayList<>();
        instrumentRepository.findAll()
                .forEach(instruments::add);
        return instruments;
    }

    public void create(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public Optional<Instrument> getById(Long instrument_id) {
        return instrumentRepository.findById(instrument_id);
    }

    public Optional<Instrument> getByName(String name) {
        return instrumentRepository.findByName(name);
    }

    public List<Instrument> getAllByType(String name) {
        List<Instrument> instruments = new ArrayList<>();
        instrumentRepository.findByType(name)
            .forEach(instruments::add);
        return instruments;
    }

    public void delete(long instrument_id) {
        instrumentRepository.deleteById(instrument_id);
    }
}
