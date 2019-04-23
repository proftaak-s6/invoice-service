package models;

import java.math.BigDecimal;
import java.math.MathContext;

public class KilometerInvoiceLine {
    private RoadType roadType;
    private int drivenDistanceInMeters;
    private BigDecimal pricePerKilometerBeforeTaxes;
    private BigDecimal accountedPriceBeforeTaxes;

    public KilometerInvoiceLine() {
    }

    public KilometerInvoiceLine(RoadType RoadType, int DrivenDistance, BigDecimal PricePerKilometerBeforeTaxes) {
        this.roadType = RoadType;
        this.drivenDistanceInMeters = DrivenDistance;
        this.pricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;

        this.accountedPriceBeforeTaxes = this.calculatePriceBeforeTaxes();
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        return this.pricePerKilometerBeforeTaxes.multiply(new BigDecimal(this.drivenDistanceInMeters))
                .divide(new BigDecimal(1000)).round(new MathContext(2));
    }

    public BigDecimal getDrivenDistanceInKilometers() {
        return new BigDecimal(this.drivenDistanceInMeters).divide(new BigDecimal(1000));
    }


    public KilometerInvoiceLine(RoadType RoadType, int DrivenDistanceInMeters, BigDecimal PricePerKilometerBeforeTaxes, BigDecimal AccountedPriceBeforeTaxes) {
        this.roadType = RoadType;
        this.drivenDistanceInMeters = DrivenDistanceInMeters;
        this.pricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
        this.accountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
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

    public BigDecimal getAccountedPriceBeforeTaxes() {
        return this.accountedPriceBeforeTaxes;
    }

    public void setAccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.accountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    public KilometerInvoiceLine RoadType(RoadType RoadType) {
        this.roadType = RoadType;
        return this;
    }

    public KilometerInvoiceLine DrivenDistanceInMeters(int DrivenDistanceInMeters) {
        this.drivenDistanceInMeters = DrivenDistanceInMeters;
        return this;
    }

    public KilometerInvoiceLine PricePerKilometerBeforeTaxes(BigDecimal PricePerKilometerBeforeTaxes) {
        this.pricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
        return this;
    }

    public KilometerInvoiceLine AccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.accountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
        return this;
    }

}