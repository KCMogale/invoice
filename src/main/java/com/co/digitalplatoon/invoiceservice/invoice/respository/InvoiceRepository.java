package com.co.digitalplatoon.invoiceservice.invoice.respository;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository  extends JpaRepository<Invoice, Long> {
}
