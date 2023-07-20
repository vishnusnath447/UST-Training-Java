package com.ust.reviewService.exception;

public class ReviewNotFoundException extends RuntimeException{
    private String uri;
    public ReviewNotFoundException(String message,String uri){
        super(message);
        this.uri=uri;
    }

    public String getUri() {
        return uri;
    }
}
