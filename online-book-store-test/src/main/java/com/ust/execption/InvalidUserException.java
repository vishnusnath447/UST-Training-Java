package com.ust.execption;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(){
        super("Invalid Credentials Given");
    }
}
