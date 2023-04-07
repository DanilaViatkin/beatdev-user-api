package com.beatdev.api.exception;

import com.beatdev.core.service.exception.InvalidUserException;
import com.beatdev.core.service.exception.NotFoundEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class ApplicationExceptionHandler {
    private final ResourceBundleMessageSource bundleMessageSource;

    @Autowired
    public ApplicationExceptionHandler(ResourceBundleMessageSource bundleMessageSource){
        this.bundleMessageSource = bundleMessageSource;
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<ExceptionResponseBody> notFoundEntityHandler(NotFoundEntityException e){
        System.out.println("NotFoundEntityException");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildExceptionResponseBody(getMessage(e.getMessage()), "40401", e.getIdentificator()));
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ExceptionResponseBody> invalidUserHandler(InvalidUserException  e){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(buildExceptionResponseBody(getMessage(e.getMessage()), "42201"));
    }

    private ExceptionResponseBody buildExceptionResponseBody(String errorMessage, String errorCode, Object value){
        return new ExceptionResponseBody(errorMessage, errorCode, value);
    }

    private ExceptionResponseBody buildExceptionResponseBody(String errorMessage, String errorCode){
        return new ExceptionResponseBody(errorMessage, errorCode);
    }

    private String getMessage(String message){
        return bundleMessageSource.getMessage(message, null,new Locale("ru", "RU"));
    }
}
