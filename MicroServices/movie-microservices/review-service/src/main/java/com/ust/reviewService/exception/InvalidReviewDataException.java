package com.ust.reviewService.exception;

public class InvalidReviewDataException extends RuntimeException{
    public InvalidReviewDataException(String message){
        super(message);
    }
}
