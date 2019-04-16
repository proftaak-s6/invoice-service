package endpoints;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import models.Invoice;
import services.MockInvoiceService;


@Path("/invoice")
public class InvoiceEndpoint {

    @Inject 
    MockInvoiceService mockInvoiceService;

    @GET
    @Path("/sample")
    @Produces({ "application/json" })
    public Response getMockInvoice() {
        Invoice invoice = mockInvoiceService.GenerateMockInvoice();
        return Response.ok().entity(invoice).build();
    }

}
