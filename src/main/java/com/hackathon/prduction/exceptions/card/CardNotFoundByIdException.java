package com.hackathon.prduction.exceptions.card;

public class CardNotFoundByIdException extends RuntimeException{
    public CardNotFoundByIdException(String message) {
        super(message);
    }
}
