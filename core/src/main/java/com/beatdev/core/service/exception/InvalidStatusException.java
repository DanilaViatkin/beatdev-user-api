package com.beatdev.core.service.exception;

public class InvalidStatusException extends RuntimeException{
    public InvalidStatusException() {
        super();
    }
    public InvalidStatusException(Exception e) {
        super(e);
    }
    public InvalidStatusException(String message){
        super(message);
    }
    public InvalidStatusException(String message, Exception e){
        super(message, e);
    }
}
