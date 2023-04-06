package com.beatdev.core.service.exception;

public class NotFoundEntityException extends RuntimeException{
    private Object identificator ;
    public NotFoundEntityException(String message, Throwable cause){
        super(message, cause);
    }
    public NotFoundEntityException(Throwable cause){
        super(cause);
    }
    public NotFoundEntityException(String message, Object identificator ){
        super(message);
        this.identificator  = identificator ;
    }

    public Object getIdentificator(){
        return identificator;
    }
}
