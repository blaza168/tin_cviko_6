package com.company.exception;

public class LinkMissingException extends RuntimeException {
    public LinkMissingException(String message) {
        super(message);
    }
}
