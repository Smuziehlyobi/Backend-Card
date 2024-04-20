package com.hackathon.prduction.exceptions.transaction;

public class TransactionNotFoundByIdException extends Exception{
    public TransactionNotFoundByIdException(String message) {
        super(message);
    }
}
