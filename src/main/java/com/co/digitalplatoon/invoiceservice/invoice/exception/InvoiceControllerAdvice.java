package com.co.digitalplatoon.invoiceservice.invoice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class InvoiceControllerAdvice  {

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occurred")
    @ExceptionHandler(IOException.class)
    public String handleIOException(String errorMsg) {
        return errorMsg;
    }
}
