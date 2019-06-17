package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.carservice.Car;
import models.carservice.OwnershipHistory;
import models.carservice.Tracker;
import models.trackservice.Step;
import services.interfaces.CarService;

public class CarServiceMock implements CarService {

    @Override
    public List<Car> getCarsByBrpId(String bsn) {
        List<Car> cars = new ArrayList<>();

        Tracker tracker = new Tracker(0, "Mock manufacturer", new Date());
        Car car = new Car(0, 0, new ArrayList<OwnershipHistory>(), "00-MO-CK", "Mock brand", "Mock series",
                "Mock vehicle type", "Mock engine type", "Mock fuel type", "Mock energy label", tracker,
                new ArrayList<Step>());
        cars.add(car);

        return cars;
    }

}