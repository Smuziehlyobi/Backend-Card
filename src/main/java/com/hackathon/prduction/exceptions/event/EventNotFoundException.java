package com.hackathon.prduction.exceptions.event;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String  message) {
        super(message);
    }
}