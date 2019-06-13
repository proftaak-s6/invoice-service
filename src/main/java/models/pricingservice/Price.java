package models.pricingservice;

public class Price {
    private double price;

    public Price() {
    }

    public Price(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + " price='" + getPrice() + "'" + "}";
    }

}