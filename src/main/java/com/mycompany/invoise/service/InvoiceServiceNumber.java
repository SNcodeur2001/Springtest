package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;

public class InvoiceServiceNumber implements InvoiceServiceInterface{

    // Variable statique pour garder la trace du dernier numéro de facture utilisé
    private static long lastNumber = 0;

    // Instance de InvoiceRepository pour gérer la communication avec le stockage des factures mais en
    //utilisant une interface au lieu d'instancier invoiceRepository directement
    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // Méthode pour créer une nouvelle facture
    public void createInvoice(Invoice invoice){
        // Incrémente le dernier numéro de facture et l'attribue à la nouvelle facture
        invoice.setNumber(String.valueOf(++lastNumber));

        // Enregistre la nouvelle facture dans le stockage
        invoiceRepository.create(invoice);
    }
}
