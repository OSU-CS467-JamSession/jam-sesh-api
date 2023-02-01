package com.gcp.springboot.jamsession.api.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gcp.springboot.jamsession.api.user.User;
import com.gcp.springboot.jamsession.api.user.UserRepository;
import com.gcp.springboot.jamsession.api.user.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/instruments")
    public List<Instrument> getInstruments() {
        return instrumentService.getInstruments();
    }

    @RequestMapping("/instrument/{instrument_id}")
    public Optional<Instrument> getInstrument(@PathVariable(value = "instrument_id") long instrumentId) {
        return instrumentService.getInstrumentById(instrumentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/instrument")
    public void createInstrument(@RequestBody Instrument instrument) {
        instrumentService.createInstrument(instrument);
    }

    @DeleteMapping("/instrument/{instrument_id}")
    public void deleteInstrument(@PathVariable(value = "instrument_id") long instrumentId) {
        instrumentService.deleteInstrument(instrumentId);
    }

    @PostMapping("/user/{user_id}/instrument")
    public ResponseEntity<User> addUserInstrument(@PathVariable(value = "user_id") Long userId, @RequestBody Instrument instrument) {
        User user = userService.getUserById(userId).get();
        user.addInstrument(instrument);
        userService.updateUser(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
