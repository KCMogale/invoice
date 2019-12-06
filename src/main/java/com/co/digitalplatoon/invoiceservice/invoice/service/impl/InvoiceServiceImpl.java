package com.co.digitalplatoon.invoiceservice.invoice.service.impl;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import com.co.digitalplatoon.invoiceservice.invoice.entity.LineItem;
import com.co.digitalplatoon.invoiceservice.invoice.exception.ResourceException;
import com.co.digitalplatoon.invoiceservice.invoice.respository.InvoiceRepository;
import com.co.digitalplatoon.invoiceservice.invoice.respository.LineItemRepository;
import com.co.digitalplatoon.invoiceservice.invoice.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final LineItemRepository lineItemRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, LineItemRepository lineItemRepository) {
        this.invoiceRepository = invoiceRepository;
        this.lineItemRepository = lineItemRepository;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) throws ResourceException {
        Invoice returnInv = null;
        if (invoice == null) {
            throw new ResourceException("No invoice to be added");
        }

        Invoice inv = invoiceRepository.save(invoice);
        List<LineItem> lineItems = invoice.getLineItems();

        if (!lineItems.isEmpty()) {
            for (LineItem lineItem : lineItems) {
                lineItem.setInvoice(invoiceRepository.save(invoice));
                lineItemRepository.save(lineItem);
            }
        }

        Optional<Invoice> invoiceList = invoiceRepository.findById(inv.getId());
        if (invoiceList.isPresent()) {
            returnInv = invoiceList.get();
        }
        return returnInv;
    }

    @Override
    public List<Invoice> viewAllInvoices() {
        return iterateThroughList(invoiceRepository.findAll());
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

    private List<Invoice> iterateThroughList(Iterable<Invoice> list){
        ArrayList<Invoice> invoices = new ArrayList<>();
        list.forEach(invoices::add);
        return invoices;
    }
}
