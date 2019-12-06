package com.co.digitalplatoon.invoiceservice.invoice.dto;

import java.util.Date;

public class InvoiceDTO {

    private Long id;
    private String client;
    private Long vatRate;
    private Date invoiceDate;

    public InvoiceDTO(Long id, String client, Long vatRate, Date invoiceDate) {
        this.id = id;
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
