package endpoints;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import models.Invoice;
import services.MockInvoiceService;
import services.PdfService;

@Path("/pdf")
@Produces("application/pdf")
public class PdfEndpoint {

    @Inject
    PdfService pdfService;

    @Inject 
    MockInvoiceService mockInvoiceService;

    @GET
    public Response getInvoicePdfFile() {
        ResponseBuilder response = Response.ok().entity(pdfService.GetInvoicePdf(mockInvoiceService.GenerateMockInvoice()));
        response.header("Content-Disposition", "attachment; filename=invoice.pdf");
        return response.build();
    }

    @POST
    @Consumes("application/json")
    public Response getInvoicePdfFileFromInvoice(Invoice invoice){
        ResponseBuilder response = Response.ok().entity(pdfService.GetInvoicePdf(invoice));
        response.header("Content-Disposition", "attachment; filename=invoice.pdf");
        return response.build();
    }

    @POST
    @Path("/mirror")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getMirrorJson(Invoice invoice){
        return Response.ok().entity(invoice).build();
    }

    @GET
    @Path("/sample")
    public Response getSamplePdfFile() {
        ResponseBuilder response = Response.ok().entity(pdfService.GetSamplePdf());
        response.header("Content-Disposition", "attachment; filename=invoice.pdf");
        return response.build();
    }

}
