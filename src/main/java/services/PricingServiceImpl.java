package services;

import java.util.Date;

import models.pricingservice.Price;
import services.interfaces.PricingService;

public class PricingServiceImpl implements PricingService {

    @Override
    public Price getRoadPrice(String roadName, Date date) {
        return new Price(0);
    }

}