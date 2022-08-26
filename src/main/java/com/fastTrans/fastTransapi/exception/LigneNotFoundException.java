package com.fastTrans.fastTransapi.exception;

public class LigneNotFoundException extends RuntimeException{

    public LigneNotFoundException(){}
    
    public LigneNotFoundException(String message){
        super(message);
    }
    
}
