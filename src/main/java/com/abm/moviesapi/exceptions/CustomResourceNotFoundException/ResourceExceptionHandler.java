package com.abm.moviesapi.exceptions.CustomResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    //Add an exception handler for ResourceNotFoundException

    @ExceptionHandler
    public ResponseEntity<ResourceErrorResponse> handleException (ResourceNotFoundException exception){
        // create ResourceErrorResponse
        ResourceErrorResponse errorResponse =
                new ResourceErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    //Catching all exceptions
    @ExceptionHandler
    public ResponseEntity<ResourceErrorResponse> handleException (Exception exception){
        // create ResourceErrorResponse
        ResourceErrorResponse errorResponse =
                new ResourceErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
