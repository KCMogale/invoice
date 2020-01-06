package com.co.digitalplatoon.invoiceservice.invoice.controller;

import com.co.digitalplatoon.invoiceservice.invoice.entity.Invoice;
import com.co.digitalplatoon.invoiceservice.invoice.service.impl.InvoiceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class InvoiceControllerTest {

    private MockMvc mockMvc;
    private List<Invoice> invoiceList;

    @InjectMocks
    private InvoiceController invoiceController;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(invoiceController)
                .build();

         invoiceList = Arrays.asList(
                new Invoice("Client One", 10L, new Date()),
                new Invoice("Client Two", 6L, new Date()),
                new Invoice("Client Three", 3L, new Date()));
    }

    @Test
    public void viewAllInvoices() {
        System.out.println(invoiceService);
    }

    @Test
    public void viewInvoice() {
    }

    @Test
    public void addInvoice() {
    }

}