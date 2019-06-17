package services.interfaces;

import java.util.List;

import models.carservice.Car;

public interface CarService {
    List<Car> getCarsByBrpId(String brpId);
}