package endpoints;

import endpoints.dto.PaymentDto;
import models.Payment;
import services.interfaces.PaymentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/payment")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentEndpoint {

    @Inject
    PaymentService paymentService;

    @GET
    public Response getAll(){
        List<Payment> paymentList = paymentService.getAll();
        if (paymentList.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT.getStatusCode(), "No payments found").build();
        }

        return Response.ok()
                .entity(paymentList)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        Payment payment = paymentService.getById(id);
        if (payment == null){
            return Response.status(Response.Status.NOT_FOUND.getStatusCode(), "No payment found").build();
        }
        return Response.ok()
                .entity(payment)
                .build();
    }
    @PUT
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Payment paymentToUpdate) {
        Payment payment;

        try{
            payment = paymentService.update(paymentToUpdate);
        }catch (Exception e){
            return Response.status(Response.Status.NOT_MODIFIED.getStatusCode(), e.toString()).build();
        }
        return Response.ok()
                .entity(payment)
                .build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        try{
            paymentService.delete(id);
        }catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.toString()).build();
        }

        return Response.ok()
                .build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PaymentDto paymentDto, @Context UriInfo context) {
        Payment payment;

        try{
            payment = paymentService.create(paymentDto.toModel());
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.toString()).build();
        }

        URI location = context.getAbsolutePathBuilder()
                .path(payment.getBsn())
                .build();

        return Response.status(Response.Status.CREATED.getStatusCode(), location.toString()).build();
    }
}
