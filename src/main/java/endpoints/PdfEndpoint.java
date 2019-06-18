package endpoints;

import java.text.SimpleDateFormat;
import java.time.Month;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import models.Invoice;
import services.InvoiceServiceImpl;
import services.PdfServiceImpl;

@Path("/pdf")
@Produces("application/pdf")
public class PdfEndpoint {

    @Inject
    PdfServiceImpl pdfService;

    @Inject
    InvoiceServiceImpl invoiceService;

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{brpId}/{year}/{month}")
    public Response getInvoice(@PathParam("brpId") long brpId, @PathParam("year") int year,
            @PathParam("month") int month) {

        Month actualMonth = Month.values()[month];
        Invoice invoice = this.invoiceService.createInvoice(brpId, year, actualMonth);

        ResponseBuilder response = Response.ok().entity(pdfService.GenerateInvoicePdf(invoice));
        response.header("Content-Disposition", "attachment; filename=" + this.getFileName(invoice) + ".pdf");
        return response.build();
    }

    private String getFileName(Invoice invoice) {
        String date = new SimpleDateFormat("yyyy-MM").format(invoice.getInvoiceDate());
        return "Rekeningrijden_" + String.join("_", invoice.getPersonalInformation().getFullname().split(" ")) + "_" + date;
    }
}
