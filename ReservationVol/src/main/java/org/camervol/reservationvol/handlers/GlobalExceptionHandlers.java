package org.camervol.reservationvol.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandlers {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handle(EntityNotFoundException e) {
        ExceptionRepresentation representation = new ExceptionRepresentation();
        representation.setErrorMessage(e.getMessage());
        representation.setErrorCode(HttpStatus.NOT_FOUND.value());
        representation.setTime(LocalDateTime.now());
        return new ResponseEntity<>(representation, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionRepresentation> handle(IllegalArgumentException e) {
        ExceptionRepresentation representation = new ExceptionRepresentation();
        representation.setErrorMessage(e.getMessage());
        representation.setErrorCode(HttpStatus.NOT_FOUND.value());
        representation.setTime(LocalDateTime.now());
        return new ResponseEntity<>(representation, HttpStatus.NOT_FOUND);
    }
}

