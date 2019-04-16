package models;

import java.math.BigDecimal;

public class VehicleInvoice {
    public String DisplayName;
    public String LicensePlate;

    public RegionalInvoice RegionalInvoice;
    public KilometerInvoice KilometerInvoice;

    public VehicleInvoice() {
    }

    public VehicleInvoice(String DisplayName, String LicensePlate, RegionalInvoice RegionalInvoice,
            KilometerInvoice KilometerInvoice) {
        this.DisplayName = DisplayName;
        this.LicensePlate = LicensePlate;
        this.RegionalInvoice = RegionalInvoice;
        this.KilometerInvoice = KilometerInvoice;
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        return this.RegionalInvoice.calculatePriceBeforeTaxes().add(this.KilometerInvoice.calculatePriceBeforeTaxes());
    }

    // Getters and setters
    public String getDisplayName() {
        return this.DisplayName;
    }

    public void setDisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public String getLicensePlate() {
        return this.LicensePlate;
    }

    public void setLicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
    }

    public RegionalInvoice getRegionalInvoice() {
        return this.RegionalInvoice;
    }

    public void setRegionalInvoice(RegionalInvoice RegionalInvoice) {
        this.RegionalInvoice = RegionalInvoice;
    }

    public KilometerInvoice getKilometerInvoice() {
        return this.KilometerInvoice;
    }

    public void setKilometerInvoice(KilometerInvoice KilometerInvoice) {
        this.KilometerInvoice = KilometerInvoice;
    }

    public VehicleInvoice DisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
        return this;
    }

    public VehicleInvoice LicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
        return this;
    }

    public VehicleInvoice RegionalInvoice(RegionalInvoice RegionalInvoice) {
        this.RegionalInvoice = RegionalInvoice;
        return this;
    }

    public VehicleInvoice KilometerInvoice(KilometerInvoice KilometerInvoice) {
        this.KilometerInvoice = KilometerInvoice;
        return this;
    }
}