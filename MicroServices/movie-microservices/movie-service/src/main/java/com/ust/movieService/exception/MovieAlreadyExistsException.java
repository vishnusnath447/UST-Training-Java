package com.ust.movieService.exception;

public class MovieAlreadyExistsException extends RuntimeException{

    private String uri;

    public MovieAlreadyExistsException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
