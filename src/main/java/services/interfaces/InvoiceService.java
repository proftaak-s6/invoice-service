package services.interfaces;

import java.time.Month;

import models.Invoice;

public interface InvoiceService {
    Invoice createInvoice(long brpId, int year, Month month);
}