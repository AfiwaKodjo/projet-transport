package com.fastTrans.fastTransapi.exception;

public class LigneConflictException extends RuntimeException{

    public LigneConflictException(){}
    
    public LigneConflictException(String message){
        super(message);
    }
    
}
