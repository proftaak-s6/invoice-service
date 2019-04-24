package services;

import java.io.ByteArrayInputStream;

import javax.enterprise.context.ApplicationScoped;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import models.Invoice;
import pdfservices.iTextPdfBuilder;

@ApplicationScoped
public class PdfService {

    private Document document;

    public PdfService() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));

        this.document = new Document(pdfDoc);
    }

    public ByteArrayInputStream GetSamplePdf() {
        String text = "This is the text of my pdf";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));

        this.document = new Document(pdfDoc);
        this.document.add(new Paragraph(text));
        this.document.close();

        return new ByteArrayInputStream(baos.toByteArray());
    }

    public ByteArrayInputStream GetInvoicePdf(Invoice invoice) {
        ByteArrayOutputStream  baos = new iTextPdfBuilder().Construct(invoice);
        
        return new ByteArrayInputStream(baos.toByteArray());
    }

}