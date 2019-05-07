package models.input;

import java.util.List;

public class Trip {
    private List<TripPoint> tripPoints;
    private Vehicle vehicle;


    public Trip() {
    }

    public Trip(List<TripPoint> tripPoints, Vehicle vehicle) {
        this.tripPoints = tripPoints;
        this.vehicle = vehicle;
    }

    public List<TripPoint> getTripPoints() {
        return this.tripPoints;
    }

    public void setTripPoints(List<TripPoint> tripPoints) {
        this.tripPoints = tripPoints;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}