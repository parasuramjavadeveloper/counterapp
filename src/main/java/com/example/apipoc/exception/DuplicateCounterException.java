package com.example.apipoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Y.Parasuram
 *
 */
/**
 * An Exception that can be thrown when duplicate counter is encountered
 */
@ResponseStatus(value = HttpStatus.IM_USED)
public class DuplicateCounterException extends RuntimeException {

    public DuplicateCounterException(String message) {
        super(message);
    }
}
