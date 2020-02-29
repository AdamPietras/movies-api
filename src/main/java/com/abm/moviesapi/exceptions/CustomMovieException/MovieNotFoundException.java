package com.abm.moviesapi.exceptions.CustomMovieException;

import com.abm.moviesapi.exceptions.CustomResourceNotFoundException.ResourceNotFoundException;

public class MovieNotFoundException extends ResourceNotFoundException {
    public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MovieNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}