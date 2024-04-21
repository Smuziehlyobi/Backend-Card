package com.hackathon.prduction.exceptions.card;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException (String message) {
        super(message);
    }
}
