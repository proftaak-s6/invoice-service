package services;

import models.Invoice;
import models.Payment;
import models.PersonalInformation;
import models.carservice.Car;
import models.pricingservice.Price;
import models.trackservice.Step;
import services.interfaces.InvoiceService;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gson.Gson;

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
    public Invoice createInvoice(long brpId, int year, Month month) {
        // 1. Get cars by bsn
        List<Car> cars = this.carService.getCarsByBrpId(brpId);

        // 2. For each car
        for (Car car : cars) {
            List<Step> steps = trackService.getDriven(car.getTracker().getId(), year, month);

            // 3. Go get the steps of the tracker attached to the car
            car.setDrivenSteps(steps);
            for (Step step : car.getDrivenSteps()) {

                // 4. Calculate price based on the date of the first location in the step and
                // set it to the step
                try {
                    Date d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(step.getLocation().getDate());
                    Price pricePerMeterForStep = pricingService.getRoadPrice(step.getLocation().getName(), d);

                    step.setPriceToPay(((double) step.getDistance()) * pricePerMeterForStep.getPrice());
                } catch (Exception e) {
                    //
                }
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