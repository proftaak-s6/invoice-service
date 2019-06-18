package services;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import models.carservice.Car;
import services.interfaces.CarService;

public class CarServiceImpl extends BaseClientService implements CarService {

    private static final String BASE_URI = "http://car.fontys-project.nl/";

    @Override
    public List<Car> getCarsByBrpId(long brpId) {
        List<Car> cars = getClient().target(BASE_URI + "/car/owner-id/" + brpId).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Car>>() {
                });
        return cars;
    }

}