package com.co.digitalplatoon.invoiceservice.invoice.service.impl;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import com.co.digitalplatoon.invoiceservice.invoice.respository.InvoiceRepository;
import com.co.digitalplatoon.invoiceservice.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> viewAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice viewInvoice(Long id) {
        Invoice invoiceFound = null;
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if(invoice.isPresent()) {
            invoiceFound = invoice.get();
        }
        return invoiceFound;
    }
}
