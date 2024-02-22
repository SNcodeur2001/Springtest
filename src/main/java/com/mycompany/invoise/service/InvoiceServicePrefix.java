package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;


public class InvoiceServicePrefix implements InvoiceServiceInterface{

    private static long lastNumber = 112;
    //plus besoin d'instancier la classe InvoiceRepositoryMichel on appelle seulement l'interface
    //private InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf("INV_"+(++lastNumber)));
        invoiceRepository.create(invoice);
    }
}
