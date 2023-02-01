package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    // instruments
    // -----
    @RequestMapping("/instruments")
    public List<Instrument> getInstruments() {
        return instrumentService.getAll();
    }

    @RequestMapping("/instruments/{type}")
    public List<Instrument> getInstrumentsByType(@PathVariable(value = "type") String type) {
        return instrumentService.getAllByType(type);
    }

    // instrument
    // -----
    @PostMapping("/instrument")
    public void createInstrument(@RequestBody Instrument instrument) {
        instrumentService.create(instrument);
    }

    @RequestMapping("/instrument/{instrument_id}")
    public Optional<Instrument> getInstrument(@PathVariable(value = "instrument_id") Long id) {
        return instrumentService.getById(id);
    }

    @DeleteMapping("/instrument/{instrument_id}")
    public void deleteInstrument(@PathVariable(value = "instrument_id") Long id) {
        instrumentService.delete(id);
    }

    // user/.../instrument
    // -----
    @PostMapping("/user/{user_id}/instrument")
    public ResponseEntity<User> addUserInstrument(@PathVariable(value = "user_id") Long userId, 
            @RequestParam(required = false, value= "id") Long instrumentId,
            @RequestParam(required = false, value= "name") String instrumentName) {

        Optional<Instrument> instrument = (instrumentId != null) ? 
            instrumentService.getById(instrumentId) : instrumentService.getByName(instrumentName);

        Optional<User> user = userService.getUserById(userId);

        // TODO: Implement exception catching instead of .get()
        user.get().addInstrument(instrument.get());
        userService.updateUser(user.get());
        return new ResponseEntity<>(user.get(), HttpStatus.CREATED);
    }

    @RequestMapping("/user/{user_id}/instruments")
    public Set<Instrument> getUsersInstruments(@PathVariable(value = "user_id") Long id) {
        Optional<User> user = userService.getUserById(id);

        // TODO: Implement exception catching instead of .get()
        return user.get().getInstruments();
    }

    @DeleteMapping("/user/{user_id}/instrument")
    public ResponseEntity<User> removeUserInstrument(@PathVariable(value = "user_id") Long userId, 
            @RequestParam(required = false, value= "id") Long instrumentId,
            @RequestParam(required = false, value= "name") String instrumentName) {

        Optional<Instrument> instrument = (instrumentId != null) ? 
        instrumentService.getById(instrumentId) : instrumentService.getByName(instrumentName);

        Optional<User> user = userService.getUserById(userId);

        // TODO: Implement exception catching instead of .get()
        user.get().removeInstrument(instrument.get());
        userService.updateUser(user.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
