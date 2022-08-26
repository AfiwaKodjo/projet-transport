package com.fastTrans.fastTransapi.exception;

public class PtArretBadRequestException extends RuntimeException{

    public PtArretBadRequestException(){}
    
    public PtArretBadRequestException(String message){
        super(message);
    }
}
