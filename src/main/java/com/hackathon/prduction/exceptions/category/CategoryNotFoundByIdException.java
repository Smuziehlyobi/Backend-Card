package com.hackathon.prduction.exceptions.category;

public class CategoryNotFoundByIdException extends Exception{
    public CategoryNotFoundByIdException(String message) {
        super(message);
    }
}
