package services;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import models.pricingservice.Price;
import services.interfaces.PricingService;

public class PricingServiceImpl extends BaseClientService implements PricingService {

    private static final String BASE_URI = "http://pricing.fontys-project.nl/";

    @Override
    public Price getRoadPrice(String roadName, Date date) {
        Price price = getClient().target(BASE_URI + "/prices/" + roadName + "/" + date)
                .request(MediaType.APPLICATION_JSON).get(Price.class);
        return price;
    }

}