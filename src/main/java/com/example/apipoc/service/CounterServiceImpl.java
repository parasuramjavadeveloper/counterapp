package com.example.apipoc.service;

import com.example.apipoc.dto.Counter;
import com.example.apipoc.exception.DuplicateCounterException;
import com.example.apipoc.util.CounterUtil;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Y.Parasuram
 *
 */
@Service
public class CounterServiceImpl implements CounterService {

    private static Map<Integer, Counter> countersMap = new LinkedHashMap<>();

    /**
     * Get List of Counters
     */
    @Override
    public List<Counter> getAllCounter() {
        return countersMap.values().stream().collect(Collectors.toList());
    }

    /**
     * Returns Counter
     *
     * @param id
     * @return
     */
    @Override
    public Counter getCounter(Integer id) {
        return countersMap.get(id);
    }

    /**
     * Creates the counter and adds to Map
     *
     * @param counter
     * @return
     */
    @Override
    public Counter createCounter(Counter counter) {
        if(counter.getId() == null) {
            counter.setId(CounterUtil.getNextSequence());
        }
        addCounterToMap(counter);
        return counter;
    }

    /**
     * Increment counter value by one
     *
     * @param counter
     */
    @Override
    public void incrementCounter(Counter counter) {
        counter.increaseCount();
    }

    /**
     * Adds counter to counter map
     *
     * @param counter
     */
    private void addCounterToMap(Counter counter) {
        Integer counterId = counter.getId();
        if (countersMap.containsKey(counterId)) {
            throw new DuplicateCounterException("Counter already exists");
        }
        countersMap.put(counter.getId(), counter);
    }
}
