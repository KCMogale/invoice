package com.co.digitalplatoon.invoiceservice.invoice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private ArrayList<LineItem> lineItems;
    private String client;
    private long vatRate;
    private Date invoiceDate;
    private BigDecimal vat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getVatRate() {
        return vatRate;
    }

    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getTotal() {
        BigDecimal invoiceTotal = BigDecimal.valueOf(BigDecimal.ROUND_CEILING);
        for (LineItem lineItem : lineItems) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
            invoiceTotal = bigDecimal.add(lineItem.getLineItemTotal());
        }
        return invoiceTotal;
    }

    public BigDecimal getSubTotal() {
        BigDecimal subTotal = BigDecimal.valueOf(BigDecimal.ROUND_CEILING);
        for (LineItem lineItem : lineItems) {
            subTotal = lineItem.getUnitPrice().multiply(BigDecimal.valueOf(lineItem.getQuantity()));
        }
        return subTotal;
    }

}
