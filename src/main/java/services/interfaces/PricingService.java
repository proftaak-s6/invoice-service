package services.interfaces;

import java.util.Date;

import models.pricingservice.Price;

public interface PricingService {
    Price getRoadPrice(String roadName, Date date);
}