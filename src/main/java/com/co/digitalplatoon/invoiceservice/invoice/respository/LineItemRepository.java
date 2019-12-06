package com.co.digitalplatoon.invoiceservice.invoice.respository;

import com.co.digitalplatoon.invoiceservice.invoice.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}
