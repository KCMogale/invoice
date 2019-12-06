package com.co.digitalplatoon.invoiceservice.invoice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private String client;
    private Long vatRate;
    private Date invoiceDate;

    public Invoice(String client, Long vatRate, Date invoiceDate) {
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
    }

    public Invoice() {  }

    @OneToMany(mappedBy = "invoice")
    private List<LineItem> lineItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
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

    @Transient
    public BigDecimal getVat() {
        BigDecimal vatValue = new BigDecimal(0);
        if (vatRate != null) {
            vatValue = getSubTotal().multiply(BigDecimal.valueOf(vatRate/100));
        }
        return vatValue.setScale(2, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getTotal() {
        return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getSubTotal() {
        BigDecimal subTotal = new BigDecimal(0);
        for (LineItem lineItem : lineItems) {
            subTotal = subTotal.add(lineItem.getLineItemTotal());
        }
        return subTotal.setScale(2, RoundingMode.HALF_UP);
    }
}