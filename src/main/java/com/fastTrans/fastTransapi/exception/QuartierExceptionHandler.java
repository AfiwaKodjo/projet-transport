package com.fastTrans.fastTransapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuartierExceptionHandler {
    
    @ExceptionHandler({QuartierNotFoundException.class})
    public ResponseEntity<Object> handleQuartierNotFoundException(QuartierNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({QuartierBadRequestException.class})
    public ResponseEntity<Object> handleQuartierBadRequestException(QuartierBadRequestException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({QuartierConflictException.class})
    public ResponseEntity<Object> handleQuartierConflictException(QuartierConflictException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    
}
