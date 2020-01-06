package com.co.digitalplatoon.invoiceservice.invoice.controller;

import com.co.digitalplatoon.invoiceservice.invoice.dto.InvoiceDTO;
import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import com.co.digitalplatoon.invoiceservice.invoice.exception.ResourceException;
import com.co.digitalplatoon.invoiceservice.invoice.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    @Autowired
    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public List<Invoice> viewAllInvoices() {
        return invoiceService.viewAllInvoices();
    }

    @GetMapping("/invoices/{invoiceId}")
    public Invoice viewInvoice(@PathVariable(value = "invoiceId") Long invoiceId) throws ResourceException {
        return invoiceService.viewInvoice(invoiceId).orElseThrow(
                () -> new ResourceException("Invoice not found with invoiceId " + invoiceId)
        );
    }

    @PostMapping("/invoices")
    public Invoice addInvoice(@RequestBody InvoiceDTO invoiceDTO) throws ResourceException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setClient(invoiceDTO.getClient());
        invoice.setVatRate(invoiceDTO.getVatRate());
        return invoiceService.addInvoice(invoice);
    }

}
