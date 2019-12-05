package com.co.digitalplatoon.invoiceservice.invoice.service;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice addInvoice(Invoice invoice);
    List<Invoice> viewAllInvoices();
    Invoice viewInvoice(Long id);
}
