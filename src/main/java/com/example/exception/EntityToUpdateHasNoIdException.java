package com.example.exception;


public class EntityToUpdateHasNoIdException extends RuntimeException {
    public EntityToUpdateHasNoIdException(String message) {
        super(message);
    }
}
