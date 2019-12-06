package com.co.digitalplatoon.invoiceservice.invoice.exception;

public class ResourceException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public ResourceException() {
        super();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ResourceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }


}
