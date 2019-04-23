package models;

import java.math.BigDecimal;

public class VehicleInvoice {
    private String displayName;
    private String licensePlate;

    private RegionalInvoice regionalInvoice;
    private KilometerInvoice kilometerInvoice;

    public VehicleInvoice() {
    }

    public VehicleInvoice(String DisplayName, String LicensePlate, RegionalInvoice RegionalInvoice,
            KilometerInvoice KilometerInvoice) {
        this.displayName = DisplayName;
        this.licensePlate = LicensePlate;
        this.regionalInvoice = RegionalInvoice;
        this.kilometerInvoice = KilometerInvoice;
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        return this.regionalInvoice.calculatePriceBeforeTaxes().add(this.kilometerInvoice.calculatePriceBeforeTaxes());
    }

    // Getters and setters
    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String DisplayName) {
        this.displayName = DisplayName;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String LicensePlate) {
        this.licensePlate = LicensePlate;
    }

    public RegionalInvoice getRegionalInvoice() {
        return this.regionalInvoice;
    }

    public void setRegionalInvoice(RegionalInvoice RegionalInvoice) {
        this.regionalInvoice = RegionalInvoice;
    }

    public KilometerInvoice getKilometerInvoice() {
        return this.kilometerInvoice;
    }

    public void setKilometerInvoice(KilometerInvoice KilometerInvoice) {
        this.kilometerInvoice = KilometerInvoice;
    }

    public VehicleInvoice DisplayName(String DisplayName) {
        this.displayName = DisplayName;
        return this;
    }

    public VehicleInvoice LicensePlate(String LicensePlate) {
        this.licensePlate = LicensePlate;
        return this;
    }

    public VehicleInvoice RegionalInvoice(RegionalInvoice RegionalInvoice) {
        this.regionalInvoice = RegionalInvoice;
        return this;
    }

    public VehicleInvoice KilometerInvoice(KilometerInvoice KilometerInvoice) {
        this.kilometerInvoice = KilometerInvoice;
        return this;
    }
}