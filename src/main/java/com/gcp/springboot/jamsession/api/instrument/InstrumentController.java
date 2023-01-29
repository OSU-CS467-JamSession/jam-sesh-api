package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @RequestMapping("/instruments")
    public List<Instrument> getInstruments() {
        return instrumentService.getInstruments();
    }

    @RequestMapping("/instrument/{instrumentId}")
    public Optional<Instrument> getInstrument(@PathVariable long instrumentId) {
        return instrumentService.getInstrumentById(instrumentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/instrument")
    public void createInstrument(@RequestBody Instrument instrument) {
        instrumentService.createInstrument(instrument);
    }

    @DeleteMapping("/instrument/{instrumentId}")
    public void deleteInstrument(@PathVariable long instrumentId) {
        instrumentService.deleteInstrument(instrumentId);
    }
}
