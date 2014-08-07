package com.ratemytree.rmt.restapi;

import com.ratemytree.rmt.EntryNotFoundException;
import com.ratemytree.rmt.VoterException;
import com.ratemytree.rmt.user.UserServiceException;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
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

    @ExceptionHandler(UserServiceException.class)
    ResponseEntity<String> userService(UserServiceException e) {

        return new ResponseEntity<>(e.getMessage(), CONFLICT);
    }


    @ExceptionHandler(EntryNotFoundException.class)
    ResponseEntity<String> entryNotFound(EntryNotFoundException e) {

        return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> illegalArgument(IllegalArgumentException e) {

        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    HttpEntity<ValidationErrorDTO> processValidationError(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        ValidationErrorDTO validationErrorDTO = processFieldErrors(fieldErrors);
        return new ResponseEntity<>(validationErrorDTO, BAD_REQUEST);
    }

    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();

        for (FieldError fieldError : fieldErrors) {
            validationErrorDTO.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return validationErrorDTO;
    }


}
