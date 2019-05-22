package models;

import java.util.List;
import models.input.Vehicle;

public class VehicleInvoice {
    private Vehicle vehicle;

    private List<RegionalInvoiceLine> regionalInvoiceLines;
    private List<KilometerInvoiceLine> kilometerInvoiceLines;


    public VehicleInvoice() {
        
    }

    public VehicleInvoice(Vehicle vehicle, List<RegionalInvoiceLine> regionalInvoiceLines, List<KilometerInvoiceLine> kilometerInvoiceLines) {
        this.vehicle = vehicle;
        this.regionalInvoiceLines = regionalInvoiceLines;
        this.kilometerInvoiceLines = kilometerInvoiceLines;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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