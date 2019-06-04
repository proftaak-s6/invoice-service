package endpoints;

import services.PaypalService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/paypal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaypalEndpoint {

    @Inject
    PaypalService paypalService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pay() {

        try{
            paypalService.capturePaypalAPI();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.toString()).build();
        }

        return Response.ok().build();
    }
}
