package com.stackroute.exception;

public class Account {
    private double amount;

    public Account(double amount){
        this.amount=amount;
    }
    public Account(){}

    public double getAccountBalance() {
        return this.amount;
    }

    public double withdraw(int i) throws InsufficientFundException,NegativeIntegerException{
        try {
            if(this.amount<i){
                throw new InsufficientFundException("Insufficient Fund");
            }
            if(i<0){
                throw new NegativeIntegerException("Negative Integer");
            }
            this.amount = this.amount - i;
            return this.amount;
        }catch (NegativeIntegerException | InsufficientFundException e){
             throw e;
        }
    }
}
