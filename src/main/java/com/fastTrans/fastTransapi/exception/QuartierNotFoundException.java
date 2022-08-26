package com.fastTrans.fastTransapi.exception;

public class QuartierNotFoundException extends RuntimeException {
    
    public QuartierNotFoundException(){}
    
    public QuartierNotFoundException(String message){
        super(message);
    }
}
