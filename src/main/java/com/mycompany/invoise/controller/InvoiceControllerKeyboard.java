package com.mycompany.invoise.controller;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import java.util.Scanner;

public class InvoiceControllerKeyboard implements InvoiceControllerInterface{
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {

        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService)
    {
        this.invoiceService = invoiceService;
    }

    public void createInvoice(){
        System.out.println( "What is the customer name!" );
        Scanner clavier = new Scanner(System.in);
        String customerName = clavier.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }
}
