package com.fastTrans.fastTransapi.exception;


public class QuartierBadRequestException extends RuntimeException{

    public QuartierBadRequestException(){}
    
    public QuartierBadRequestException(String message){
        super(message);
    }
    
}
