package com.co.digitalplatoon.invoiceservice.invoice.service;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import com.co.digitalplatoon.invoiceservice.invoice.exception.ResourceException;

import java.util.List;

public interface InvoiceService {
    Invoice addInvoice(Invoice invoice) throws ResourceException;
    List<Invoice> viewAllInvoices();
    Invoice viewInvoice(Long id);
}
