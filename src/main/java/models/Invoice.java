package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Invoice {
    public String invoiceNumberString;
    public Date invoiceDate;
    public PersonalInformation personalInformation;
    public SupplierInformation supplierInformation;
    public List<VehicleInvoice> vehicleInvoices;

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

    public BigDecimal calculatePriceBeforeTaxes() {
        BigDecimal total = new BigDecimal(0);

        for (VehicleInvoice vi : vehicleInvoices) {
            total = total.add(vi.calculatePriceBeforeTaxes());
        }

        return total;
    }

    public BigDecimal calculateTaxes() {
        return this.calculatePriceAfterTaxes().subtract(this.calculatePriceBeforeTaxes());
    }

    public BigDecimal calculatePriceAfterTaxes() {
        return this.calculatePriceBeforeTaxes().multiply(new BigDecimal(1.21));
    }


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