package com.jaljeevan.waterquality.exception;

// Custom exception for handling specific cases
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
