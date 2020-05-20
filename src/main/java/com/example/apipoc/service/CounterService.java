package com.example.apipoc.service;

import com.example.apipoc.dto.Counter;

import java.util.List;

/**
 * @author Y.Parasuram
 *
 */
public interface CounterService {
    List<Counter> getAllCounter();
    Counter getCounter(Integer id);
    Counter createCounter(Counter counter);
    void incrementCounter(Counter counter);
}
