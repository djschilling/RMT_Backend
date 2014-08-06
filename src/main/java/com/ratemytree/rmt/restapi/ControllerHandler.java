package com.ratemytree.rmt.restapi;

import com.ratemytree.rmt.tree.VoterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * David Schilling - davejs92@gmail.com
 */
@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(VoterException.class)
    ResponseEntity<String> voterException(VoterException e) {

        return new ResponseEntity<>(e.getMessage(), CONFLICT);
    }

    @ExceptionHandler(EntryNotFoundException.class)
    ResponseEntity<String> entryNotFound(EntryNotFoundException e) {

        return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
    }


}
