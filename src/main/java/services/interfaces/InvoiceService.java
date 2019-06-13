package services.interfaces;

import java.time.Month;

import models.Invoice;

public interface InvoiceService {
    Invoice createInvoice(String bsn, int year, Month month);
}