package com.abm.moviesapi.exceptions.CustomCastingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CastingExceptionHandler {
    //Add an exception handler for DirectorNotFoundException

    @ExceptionHandler
    public ResponseEntity<CastingErrorResponse> handleException (CastingNotFoundException exception){
        // create DirectorErrorResponse
        CastingErrorResponse errorResponse =
                new CastingErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Catching all exceptions

    @ExceptionHandler
    public ResponseEntity<CastingErrorResponse> handleException(Exception exception){
        CastingErrorResponse errorResponse =
                new CastingErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
