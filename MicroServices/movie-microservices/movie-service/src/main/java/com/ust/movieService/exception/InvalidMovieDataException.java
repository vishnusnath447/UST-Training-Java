package com.ust.movieService.exception;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String s) {
        super(s);
    }
}