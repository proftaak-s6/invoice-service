package endpoints;

import java.io.ByteArrayInputStream;
import java.time.Month;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import models.Invoice;
import services.InvoiceServiceMock;
import services.PdfServiceImpl;

@Path("/pdf")
@Produces("application/pdf")
public class PdfEndpoint {

    @Inject
    PdfServiceImpl pdfService;

    @Inject
    InvoiceServiceMock invoiceService;

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{bsn}/{year}/{month}")
    public Response getInvoice(@PathParam("bsn") String bsn, @PathParam("year") int year,
            @PathParam("month") int month) {

        Month actualMonth = Month.values()[month];
        Invoice invoice = this.invoiceService.createInvoice(bsn, year, actualMonth);

        ResponseBuilder response = Response.ok().entity(pdfService.GenerateInvoicePdf(invoice));
        response.header("Content-Disposition", "attachment; filename=" + this.getFileName() + ".pdf");
        return response.build();
    }

    private String getFileName() {
        long time = new Date().getTime();
        return "invoice_" + time;
    }
}
