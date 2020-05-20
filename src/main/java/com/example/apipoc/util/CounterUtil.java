package com.example.apipoc.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Y.Parasuram
 *
 */
public class CounterUtil {
    private static AtomicInteger sequence = new AtomicInteger(0);

    /**
     * increments the sequence and returns
     *
     * @return
     */
    public static Integer getNextSequence() {
        return sequence.incrementAndGet();
    }
}
