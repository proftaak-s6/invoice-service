package models;

import java.math.BigDecimal;

public class KilometerInvoiceLine {
    private RoadType roadType;
    private int drivenDistanceInMeters;
    private BigDecimal pricePerKilometerBeforeTaxes;

    public KilometerInvoiceLine() {
    }

    public KilometerInvoiceLine(RoadType RoadType, int DrivenDistance, BigDecimal PricePerKilometerBeforeTaxes) {
        this.roadType = RoadType;
        this.drivenDistanceInMeters = DrivenDistance;
        this.pricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
    }

    // Getters and setters
    public RoadType getRoadType() {
        return this.roadType;
    }

    public void setRoadType(RoadType RoadType) {
        this.roadType = RoadType;
    }

    public int getDrivenDistanceInMeters() {
        return this.drivenDistanceInMeters;
    }

    public void setDrivenDistanceInMeters(int DrivenDistanceInMeters) {
        this.drivenDistanceInMeters = DrivenDistanceInMeters;
    }

    public BigDecimal getPricePerKilometerBeforeTaxes() {
        return this.pricePerKilometerBeforeTaxes;
    }

    public void setPricePerKilometerBeforeTaxes(BigDecimal PricePerKilometerBeforeTaxes) {
        this.pricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
    }

}