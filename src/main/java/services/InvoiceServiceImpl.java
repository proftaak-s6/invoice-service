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

public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    CarServiceImpl carService;

    @Inject
    TrackServiceImpl trackService;

    @Inject
    PricingServiceImpl pricingService;

    @Inject
    BrpServiceImpl brpService;

    @Inject
    PaymentServiceImpl paymentService;

    @Override
    public Invoice createInvoice(String bsn, int year, Month month) {
        // 1. Get cars by bsn
        List<Car> cars = this.carService.getCarsByBrpId(bsn);

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

        // 5. Get personal information
        PersonalInformation personalInformation = brpService.getPersonalInformation(bsn);

        // 6. TODO: Check if a payment exists for this and if it doesn't, create it
        // The payment service exists but is commented out right now
        Payment payment = paymentService.createIfNew(bsn, year, month);

        // 7. Fill the invoice object
        Invoice invoice = new Invoice(new Date(), personalInformation, payment, cars);

        return invoice;
    }

}