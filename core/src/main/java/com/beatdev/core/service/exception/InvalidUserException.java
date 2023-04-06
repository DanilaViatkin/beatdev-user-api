package com.beatdev.core.service.exception;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException() {
        super();
    }
    public InvalidUserException(Exception e) {
        super(e);
    }
    public InvalidUserException(String message){
        super(message);
    }
    public InvalidUserException(String message, Exception e){
        super(message, e);
    }
}
