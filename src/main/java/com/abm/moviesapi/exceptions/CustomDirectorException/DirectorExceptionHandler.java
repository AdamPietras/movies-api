package com.abm.moviesapi.exceptions.CustomDirectorException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DirectorExceptionHandler {
    //Add an exception handler for DirectorNotFoundException

    @ExceptionHandler
    public ResponseEntity<DirectorErrorResponse> handleException (DirectorNotFoundException exception){
        // create DirectorErrorResponse
        DirectorErrorResponse errorResponse =
                new DirectorErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Catching all exceptions

    @ExceptionHandler
    public ResponseEntity<DirectorErrorResponse> handleException(Exception exception){
        DirectorErrorResponse errorResponse =
                new DirectorErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
