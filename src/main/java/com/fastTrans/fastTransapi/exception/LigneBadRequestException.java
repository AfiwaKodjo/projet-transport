package com.fastTrans.fastTransapi.exception;

public class LigneBadRequestException extends RuntimeException{

    public LigneBadRequestException(){}
    
    public LigneBadRequestException(String message){
        super(message);
    }
    
}
