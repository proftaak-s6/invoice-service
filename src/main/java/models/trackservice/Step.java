package models.trackservice;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private int distance;
    private NamedLocation start;
    private List<DatedLocation> locations = new ArrayList<DatedLocation>();
    private double priceToPay;

    public Step() {
    }

    public Step(int distance, NamedLocation start, List<DatedLocation> locations) {
        this.distance = distance;
        this.start = start;
        this.locations = locations;
        this.priceToPay = 0.0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public NamedLocation getStart() {
        return this.start;
    }

    public void setStart(NamedLocation start) {
        this.start = start;
    }

    public List<DatedLocation> getLocations() {
        return this.locations;
    }

    public void setLocations(List<DatedLocation> locations) {
        this.locations = locations;
    }

    public double getPriceToPay() {
        return this.priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }

    @Override
    public String toString() {
        return "{" + " distance='" + getDistance() + "'" + ", start='" + getStart() + "'" + ", locations='"
                + getLocations() + "'" + ", priceToPay='" + getPriceToPay() + "'" + "}";
    }

}