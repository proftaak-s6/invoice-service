package models;

import java.util.List;

public class VehicleInvoice {
    private String displayName;
    private String licensePlate;

    private List<RegionalInvoiceLine> regionalInvoiceLines;
    private List<KilometerInvoiceLine> kilometerInvoiceLines;

    public VehicleInvoice() {
    }

    public VehicleInvoice(String displayName, String licensePlate, List<RegionalInvoiceLine> regionalInvoice,
            List<KilometerInvoiceLine> kilometerInvoice) {
        this.displayName = displayName;
        this.licensePlate = licensePlate;
        this.regionalInvoiceLines = regionalInvoice;
        this.kilometerInvoiceLines = kilometerInvoice;
    }

    // Getters and setters
    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<RegionalInvoiceLine> getRegionalInvoiceLines() {
        return this.regionalInvoiceLines;
    }

    public void setRegionalInvoiceLines(List<RegionalInvoiceLine> regionalInvoiceLines) {
        this.regionalInvoiceLines = regionalInvoiceLines;
    }

    public List<KilometerInvoiceLine> getKilometerInvoiceLines() {
        return this.kilometerInvoiceLines;
    }

    public void setKilometerInvoiceLines(List<KilometerInvoiceLine> kilometerInvoiceLines) {
        this.kilometerInvoiceLines = kilometerInvoiceLines;
    }

}