package com.hackathon.prduction.exceptions;

public class InvalidRegistrationException extends RuntimeException{
    public InvalidRegistrationException(String string) {
        super(string);
    }
}
