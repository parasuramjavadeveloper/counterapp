package com.example.apipoc.controller;

import com.example.apipoc.dto.Counter;
import com.example.apipoc.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Y.Parasuram
 *
 */
@RestController
public class CounterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterController.class);

    @Autowired
    private CounterService counterService;

    @PostMapping("/counter")
    public ResponseEntity<Counter> createCounter(@RequestBody Counter counter) {
        LOGGER.debug("Counter creation request : {}", counter);
        final Counter created = counterService.createCounter(counter);
        LOGGER.debug("Created Counter {}", created);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @GetMapping("/counters")
    public ResponseEntity<List<Counter>> getCounters() {
        List<Counter> counters = counterService.getAllCounter();
        LOGGER.debug("Counters found : {}", counters);
        return new ResponseEntity<>(counters, HttpStatus.OK);
    }

    @GetMapping("/counter/{id}")
    public ResponseEntity<Counter> getCounter(@PathVariable Integer id) {
        LOGGER.debug("Counter get with id {}");
        Counter counter = counterService.getCounter(id);
        if (counter == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOGGER.info("Counter found : {}", counter);
        return new ResponseEntity<>(counter, HttpStatus.OK);
    }

    @PostMapping("/increment/{id}")
    public ResponseEntity<Counter> incrementCounter(@PathVariable Integer id) {
        Counter counter = counterService.getCounter(id);
        if (counter == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        counterService.incrementCounter(counter);
        return new ResponseEntity<>(counter, HttpStatus.OK);
    }
}
