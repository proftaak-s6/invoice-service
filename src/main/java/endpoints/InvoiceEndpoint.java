package endpoints;

import java.time.Month;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import models.Invoice;
import services.*;

@Path("")
public class InvoiceEndpoint {

    @Inject
    InvoiceServiceMock invoiceService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{bsn}/{year}/{month}")
    public Response getInvoice(@PathParam("bsn") String bsn, @PathParam("year") int year,
            @PathParam("month") int month) {

        Month actualMonth = Month.values()[month];
        Invoice invoice = this.invoiceService.createInvoice(bsn, year, actualMonth);

        return Response.ok().entity(new Gson().toJson(invoice)).build();
    }
}
