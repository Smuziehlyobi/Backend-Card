package com.hackathon.prduction.exceptions.suggestion;

public class SuggestionNotFoundByIdException extends Exception{
    public SuggestionNotFoundByIdException(String message) {
        super(message);
    }
}
