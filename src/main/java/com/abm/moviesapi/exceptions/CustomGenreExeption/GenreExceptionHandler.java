package com.abm.moviesapi.exceptions.CustomGenreExeption;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenreExceptionHandler {

    //Add an exception handler for MovieNotFoundException

    @ExceptionHandler
    public ResponseEntity<GenreErrorResponse> handleException (GenreNotFoundException exception){
        // create MovieErrorResponse
        GenreErrorResponse errorResponse =
                new GenreErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    //Catching all exceptions
    @ExceptionHandler
    public ResponseEntity<GenreErrorResponse> handleException (Exception exception){
        // create MovieErrorResponse
        GenreErrorResponse errorResponse =
                new GenreErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        System.currentTimeMillis());
        //ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
