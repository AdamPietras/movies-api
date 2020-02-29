package com.abm.moviesapi.exceptions.CustomCastingException;

import com.abm.moviesapi.exceptions.CustomResourceNotFoundException.ResourceNotFoundException;

public class CastingNotFoundException extends ResourceNotFoundException {
    public CastingNotFoundException() {
        super();
    }

    public CastingNotFoundException(String message) {
        super(message);
    }

    public CastingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CastingNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CastingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
