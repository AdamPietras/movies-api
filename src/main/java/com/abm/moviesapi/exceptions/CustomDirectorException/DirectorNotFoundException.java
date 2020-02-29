package com.abm.moviesapi.exceptions.CustomDirectorException;

import com.abm.moviesapi.exceptions.CustomResourceNotFoundException.ResourceNotFoundException;

public class DirectorNotFoundException extends ResourceNotFoundException {
    public DirectorNotFoundException() {
        super();
    }

    public DirectorNotFoundException(String message) {
        super(message);
    }

    public DirectorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectorNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DirectorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
