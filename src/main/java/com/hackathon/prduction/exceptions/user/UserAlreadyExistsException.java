package com.hackathon.prduction.exceptions.user;



public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String  message) {
        super(message);
    }
}
