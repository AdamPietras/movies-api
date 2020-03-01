package com.abm.moviesapi.exceptions.CustomMovieException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler  {

    //Add an exception handler for ResourceNotFoundException

    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException (MovieNotFoundException exception){
        // create MovieErrorResponse
        MovieErrorResponse errorResponse =
                new MovieErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    //Catching all exceptions
    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException (Exception exception){
        // create MovieErrorResponse
        MovieErrorResponse errorResponse =
                new MovieErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
