package models;

import java.math.BigDecimal;
import java.math.MathContext;

public class KilometerInvoiceLine {
    public RoadType RoadType;
    public int DrivenDistanceInMeters;
    public BigDecimal PricePerKilometerBeforeTaxes;
    public BigDecimal AccountedPriceBeforeTaxes;

    public KilometerInvoiceLine() {
    }

    public KilometerInvoiceLine(RoadType RoadType, int DrivenDistance, BigDecimal PricePerKilometerBeforeTaxes) {
        this.RoadType = RoadType;
        this.DrivenDistanceInMeters = DrivenDistance;
        this.PricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;

        this.AccountedPriceBeforeTaxes = this.calculatePriceBeforeTaxes();
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        return this.PricePerKilometerBeforeTaxes.multiply(new BigDecimal(this.DrivenDistanceInMeters))
                .divide(new BigDecimal(1000)).round(new MathContext(2));
    }

    public BigDecimal getDrivenDistanceInKilometers() {
        return new BigDecimal(this.DrivenDistanceInMeters).divide(new BigDecimal(1000));
    }


    public KilometerInvoiceLine(RoadType RoadType, int DrivenDistanceInMeters, BigDecimal PricePerKilometerBeforeTaxes, BigDecimal AccountedPriceBeforeTaxes) {
        this.RoadType = RoadType;
        this.DrivenDistanceInMeters = DrivenDistanceInMeters;
        this.PricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
        this.AccountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    // Getters and setters
    public RoadType getRoadType() {
        return this.RoadType;
    }

    public void setRoadType(RoadType RoadType) {
        this.RoadType = RoadType;
    }

    public int getDrivenDistanceInMeters() {
        return this.DrivenDistanceInMeters;
    }

    public void setDrivenDistanceInMeters(int DrivenDistanceInMeters) {
        this.DrivenDistanceInMeters = DrivenDistanceInMeters;
    }

    public BigDecimal getPricePerKilometerBeforeTaxes() {
        return this.PricePerKilometerBeforeTaxes;
    }

    public void setPricePerKilometerBeforeTaxes(BigDecimal PricePerKilometerBeforeTaxes) {
        this.PricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
    }

    public BigDecimal getAccountedPriceBeforeTaxes() {
        return this.AccountedPriceBeforeTaxes;
    }

    public void setAccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.AccountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    public KilometerInvoiceLine RoadType(RoadType RoadType) {
        this.RoadType = RoadType;
        return this;
    }

    public KilometerInvoiceLine DrivenDistanceInMeters(int DrivenDistanceInMeters) {
        this.DrivenDistanceInMeters = DrivenDistanceInMeters;
        return this;
    }

    public KilometerInvoiceLine PricePerKilometerBeforeTaxes(BigDecimal PricePerKilometerBeforeTaxes) {
        this.PricePerKilometerBeforeTaxes = PricePerKilometerBeforeTaxes;
        return this;
    }

    public KilometerInvoiceLine AccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.AccountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
        return this;
    }

}