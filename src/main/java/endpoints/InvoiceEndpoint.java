package endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import models.Invoice;
import models.carservice.Car;
import models.pricingservice.Price;
import models.trackservice.Step;
import services.CarServiceMock;
import services.MockInvoiceService;
import services.PricingServiceMock;
import services.TrackServiceMock;

@Path("")
public class InvoiceEndpoint {

    @Inject
    MockInvoiceService mockInvoiceService;

    // TODO: Implement real CarService
    @Inject
    CarServiceMock carService;

    // TODO: Implement real Trackservice, or get it directly from the simulation
    @Inject
    TrackServiceMock trackService;

    // TODO: Implement real PricingService
    @Inject
    PricingServiceMock pricingService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{bsn}/{year}/{month}")
    public Response getInvoice(@PathParam("bsn") String bsn, @PathParam("year") int year,
            @PathParam("month") int month) {
        // 1. Get cars by bsn
        List<Car> cars = this.carService.getCarsByBsn(bsn);

        // 2. For each car
        for (Car car : cars) {

            // 3. Go get the steps of the tracker attached to the car
            car.setDrivenSteps(trackService.getDriven(car.getTracker().getId(), year, month));
            for (Step step : car.getDrivenSteps()) {

                // 4. Calculate price based on the date of the first location in the step and
                // set it to the step
                Price pricePerMeterForStep = pricingService.getRoadPrice(step.getStart().getName(),
                        step.getLocations().get(0).getDate());
                step.setPriceToPay(((double) step.getDistance()) * pricePerMeterForStep.getPrice());
            }

        }

        return Response.ok().entity(new Gson().toJson(cars)).build();
    }

    @GET
    @Path("/sample")
    @Produces({ "application/json" })
    public Response getMockInvoice() {
        Invoice invoice = mockInvoiceService.GenerateMockInvoice();
        return Response.ok().entity(invoice).build();
    }

}
