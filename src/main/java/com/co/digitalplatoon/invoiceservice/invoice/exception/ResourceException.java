package com.co.digitalplatoon.invoiceservice.invoice.exception;

public class ResourceException extends Exception {

    private static final long serialVersionUID = 1L;

    public ResourceException(String errorMessage) {
        super(errorMessage);
    }
}
