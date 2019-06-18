package services;

import models.Invoice;
import models.Payment;
import models.PersonalInformation;
import models.carservice.Car;
import models.pricingservice.Price;
import models.trackservice.Step;
import services.interfaces.InvoiceService;

import java.time.Month;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class InvoiceServiceMock implements InvoiceService {

    @Inject
    CarServiceMock carService;

    @Inject
    TrackServiceMock trackService;

    @Inject
    PricingServiceMock pricingService;

    @Inject
    BrpServiceMock brpService;

    @Inject
    PaymentServiceMock paymentService;

    @Override
    public Invoice createInvoice(long brpId, int year, Month month) {
        // 1. Get cars by bsn
        List<Car> cars = this.carService.getCarsByBrpId(brpId);

        // 2. For each car
        for (Car car : cars) {

            // 3. Go get the steps of the tracker attached to the car
            car.setDrivenSteps(trackService.getDriven(car.getTracker().getId(), year, month));
            for (Step step : car.getDrivenSteps()) {

                // 4. Calculate price based on the date of the first location in the step and
                // set it to the step
                Price pricePerMeterForStep = pricingService.getRoadPrice(step.getLocation().getName(), new Date(step.getLocation().getDate()));
                step.setPriceToPay(((double) step.getDistance()) * pricePerMeterForStep.getPrice());
            }

        }

        // 5. Get personal information
        PersonalInformation personalInformation = brpService.getPersonalInformation(brpId);

        // 6. Check if a payment exists for this and if it doesn't, create it
        Payment payment = paymentService.createIfNew(brpId, year, month);

        // 7. Fill the invoice object
        Invoice invoice = new Invoice(new Date(), personalInformation, payment, cars);

        return invoice;
    }

}