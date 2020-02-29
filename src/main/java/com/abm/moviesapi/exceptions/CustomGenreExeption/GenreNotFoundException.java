package com.abm.moviesapi.exceptions.CustomGenreExeption;

import com.abm.moviesapi.exceptions.CustomResourceNotFoundException.ResourceNotFoundException;

public class GenreNotFoundException extends ResourceNotFoundException {
    public GenreNotFoundException() {
        super();
    }

    public GenreNotFoundException(String message) {
        super(message);
    }

    public GenreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GenreNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
