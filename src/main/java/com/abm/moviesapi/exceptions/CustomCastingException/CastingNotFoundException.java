package com.abm.moviesapi.exceptions.CustomCastingException;

public class CastingNotFoundException extends RuntimeException{
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
