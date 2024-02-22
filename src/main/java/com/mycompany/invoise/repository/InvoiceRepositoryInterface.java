package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;

//Ceci est une interface elle permet de diminuer la dependence entre les classes les interfaces
//peuvent etre implimentée dans d'autres interfaces
public interface InvoiceRepositoryInterface {
    void create(Invoice invoice);
}
