package com.ust.customerService.execption;

public class CustomerNotFoundException extends RuntimeException{
    private String uri;
    public CustomerNotFoundException(String message, String uri){
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
