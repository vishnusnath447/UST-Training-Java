package com.ust.reviewService.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String uri;
    public ResourceNotFoundException(String message,String uri){
        super(message);
        this.uri=uri;
    }

    public String getUri() {
        return uri;
    }
}
