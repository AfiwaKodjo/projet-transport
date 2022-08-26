package com.fastTrans.fastTransapi.exception;

public class QuartierConflictException extends RuntimeException{

    public QuartierConflictException(){}
    
    public QuartierConflictException(String message){
        super(message);
    }
}
