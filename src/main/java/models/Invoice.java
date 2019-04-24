package models;

import java.util.Date;
import java.util.List;

public class Invoice {
    private String invoiceNumberString;
    private Date invoiceDate;
    private PersonalInformation personalInformation;
    private SupplierInformation supplierInformation;
    private List<VehicleInvoice> vehicleInvoices;

    public Invoice() {
    }

    public Invoice(String invoiceNumberString, Date invoiceDate, PersonalInformation personalInformation,
            SupplierInformation supplierInformation, List<VehicleInvoice> vehicleInvoices) {
        this.invoiceNumberString = invoiceNumberString;
        this.invoiceDate = invoiceDate;
        this.personalInformation = personalInformation;
        this.supplierInformation = supplierInformation;
        this.vehicleInvoices = vehicleInvoices;
    }

    // Getters and setters
    public String getInvoiceNumberString() {
        return this.invoiceNumberString;
    }

    public void setInvoiceNumberString(String invoiceNumberString) {
        this.invoiceNumberString = invoiceNumberString;
    }

    public Date getInvoiceDate() {
        return this.invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public PersonalInformation getPersonalInformation() {
        return this.personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public SupplierInformation getSupplierInformation() {
        return this.supplierInformation;
    }

    public void setSupplierInformation(SupplierInformation supplierInformation) {
        this.supplierInformation = supplierInformation;
    }

    public List<VehicleInvoice> getVehicleInvoices() {
        return this.vehicleInvoices;
    }

    public void setVehicleInvoices(List<VehicleInvoice> vehicleInvoices) {
        this.vehicleInvoices = vehicleInvoices;
    }

}