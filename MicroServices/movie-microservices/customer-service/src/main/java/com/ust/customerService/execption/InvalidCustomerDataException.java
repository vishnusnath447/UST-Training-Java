package com.ust.customerService.execption;
public class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String s) {
        super(s);
    }
}

