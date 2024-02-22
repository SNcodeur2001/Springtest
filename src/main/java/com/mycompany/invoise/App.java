package com.mycompany.invoise;
import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;

import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){


        Scanner clavier = new Scanner(System.in);
        System.out.println("Quel est la Class de controller");
        String controllerClass = clavier.nextLine();
        System.out.println("Quel est la Class de service");
        String serviceClass = clavier.nextLine();
        System.out.println("Quel est la Class de repository");
        String repositoryClass = clavier.nextLine();

        InvoiceControllerInterface invoiceController = null ;
        InvoiceServiceInterface invoiceService = null;
        InvoiceRepositoryInterface invoiceRepository = null;

       try{
           invoiceController = (InvoiceControllerInterface)Class.forName(controllerClass).getDeclaredConstructor().newInstance();
           invoiceService = (InvoiceServiceInterface)Class.forName(serviceClass).getDeclaredConstructor().newInstance();
           invoiceRepository = (InvoiceRepositoryInterface)Class.forName(repositoryClass).getDeclaredConstructor().newInstance();

       }catch (Exception e){
           e.printStackTrace();
       }

        assert invoiceController != null;
        invoiceController.setInvoiceService(invoiceService);
        assert invoiceService != null;
        invoiceService.setInvoiceRepository(invoiceRepository);
        invoiceController.createInvoice();


    }

}
