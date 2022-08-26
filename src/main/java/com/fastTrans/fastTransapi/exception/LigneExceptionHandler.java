package com.fastTrans.fastTransapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LigneExceptionHandler {
    @ExceptionHandler({LigneNotFoundException.class})
    public ResponseEntity<Object> handleLigneNotFoundException(LigneNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({LigneBadRequestException.class})
    public ResponseEntity<Object> handleLigneBadRequestException(LigneBadRequestException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({LigneConflictException.class})
    public ResponseEntity<Object> handleLigneConflictException(LigneConflictException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    
    
}
