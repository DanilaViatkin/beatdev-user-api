package com.beatdev.api.exception;

import com.beatdev.core.service.exception.InvalidUserException;
import com.beatdev.core.service.exception.NotFoundEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<ExceptionResponseBody> notFoundEntityHandler(NotFoundEntityException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildExceptionResponseBody(e.getMessage(), "40401", e.getIdentificator()));
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ExceptionResponseBody> invalidUserHandler(InvalidUserException  e){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(buildExceptionResponseBody(e.getMessage(), "42201"));
    }

    private ExceptionResponseBody buildExceptionResponseBody(String errorMessage, String errorCode, Object value){
        return new ExceptionResponseBody(errorMessage, errorMessage, value);
    }

    private ExceptionResponseBody buildExceptionResponseBody(String errorMessage, String errorCode){
        return new ExceptionResponseBody(errorMessage, errorCode);
    }

}
