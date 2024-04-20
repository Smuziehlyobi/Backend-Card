package com.hackathon.prduction.exceptions.user;

public class UserNotFoundByIdException extends Exception{
    public UserNotFoundByIdException(String message) {
        super(message);
    }
}
