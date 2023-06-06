package com.pragma.powerup.configuration;

import com.pragma.powerup.adapters.driven.exceptions.TwilioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.configuration.Constants.NO_DATA_FOUND_EXCEPTION;
import static com.pragma.powerup.configuration.Constants.RESPONSE_ERROR_MESSAGE_KEY;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(TwilioException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            TwilioException twilioException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_DATA_FOUND_EXCEPTION));
    }
}
