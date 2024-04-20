package com.hackathon.prduction.exceptions.card;

public class CardNotFoundByIdException extends Exception{
    public CardNotFoundByIdException(String message) {
        super(message);
    }
}
