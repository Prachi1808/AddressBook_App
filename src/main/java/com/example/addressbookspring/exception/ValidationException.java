package com.example.addressbookspring.exception;
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
