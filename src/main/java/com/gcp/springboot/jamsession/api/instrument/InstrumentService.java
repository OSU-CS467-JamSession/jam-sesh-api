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

    public List<Instrument> getInstruments() {
        List<Instrument> instruments = new ArrayList<>();
        instrumentRepository.findAll()
                .forEach(instruments::add);
        return instruments;
    }

    public Optional<Instrument> getInstrumentById(Long instrument_id) {
        return instrumentRepository.findById(instrument_id);
    }

    public void createInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public void deleteInstrument(long instrument_id) {
        instrumentRepository.deleteById(instrument_id);
    }
}
