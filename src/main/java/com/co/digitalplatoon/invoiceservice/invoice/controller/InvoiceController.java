package com.co.digitalplatoon.invoiceservice.invoice.controller;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import com.co.digitalplatoon.invoiceservice.invoice.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Invoice> viewInvoice(@PathVariable(value = "invoiceId") Long invoiceId) {
        Invoice invoice = invoiceService.viewInvoice(invoiceId);
        return ResponseEntity.ok().body(invoice);
    }

    @PostMapping("/invoices")
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }

}
