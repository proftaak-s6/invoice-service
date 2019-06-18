package models.trackservice;

public class Step {
    private int distance;
    private NamedDatedLocation location;
    private double priceToPay;

    public Step() {
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }

    public NamedDatedLocation getLocation() {
        return location;
    }

    public void setLocation(NamedDatedLocation location) {
        this.location = location;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}