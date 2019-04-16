package endpoints;

import java.io.ByteArrayInputStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import services.HelloWorldService;

@Path("/pdf")
public class PdfEndpoint {

    @Inject
    HelloWorldService helloService;

    @GET
    @Produces("application/pdf")
    public Response getPdfFile() {
        String invoiceName = "invoice";

        String text = "This is the text of my pdf";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));

        Document doc = new Document(pdfDoc);
        doc.add(new Paragraph(text));
        doc.close();

        ByteArrayInputStream pdfStream = new ByteArrayInputStream(baos.toByteArray());

        ResponseBuilder response = Response.ok().entity(pdfStream);
        response.header("Content-Disposition", "attachment; filename=" + invoiceName + ".pdf");
        return response.build();
    }

}
