package services.interfaces;

import java.io.ByteArrayInputStream;

import models.Invoice;

public interface PdfService {
    ByteArrayInputStream GenerateInvoicePdf(Invoice invoice);
}