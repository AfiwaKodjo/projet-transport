package com.fastTrans.fastTransapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PtArretExceptionHandler {

    @ExceptionHandler({PtArretNotFoundException.class})
    public ResponseEntity<Object> handlePtArretNotFoundException(PtArretNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({PtArretBadRequestException.class})
    public ResponseEntity<Object> handlePtArretBadRequestException(PtArretBadRequestException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PtArretConflictException.class})
    public ResponseEntity<Object> handlePtArretConflictException(PtArretConflictException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
