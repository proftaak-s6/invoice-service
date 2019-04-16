package models;

import java.math.BigDecimal;
import java.util.List;

public class RegionalInvoice {
    public BigDecimal TotalPriceBeforeTaxes;
    public List<RegionalInvoiceLine> RegionalInvoiceLines;

    public RegionalInvoice() {
    }

    public RegionalInvoice(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.RegionalInvoiceLines = RegionalInvoiceLines;
        this.TotalPriceBeforeTaxes = calculatePriceBeforeTaxes();
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        BigDecimal total = new BigDecimal(0);

        for (RegionalInvoiceLine ril : this.RegionalInvoiceLines) {
            total = total.add(ril.calculatePriceBeforeTaxes());
        }

        return total;
    }

    public RegionalInvoice(BigDecimal TotalPriceBeforeTaxes, List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.TotalPriceBeforeTaxes = TotalPriceBeforeTaxes;
        this.RegionalInvoiceLines = RegionalInvoiceLines;
    }

    public BigDecimal getTotalPriceBeforeTaxes() {
        return this.TotalPriceBeforeTaxes;
    }

    public void setTotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.TotalPriceBeforeTaxes = TotalPriceBeforeTaxes;
    }

    // Getters and setters
    public List<RegionalInvoiceLine> getRegionalInvoiceLines() {
        return this.RegionalInvoiceLines;
    }

    public void setRegionalInvoiceLines(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.RegionalInvoiceLines = RegionalInvoiceLines;
    }

    public RegionalInvoice TotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.TotalPriceBeforeTaxes = TotalPriceBeforeTaxes;
        return this;
    }

    public RegionalInvoice RegionalInvoiceLines(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.RegionalInvoiceLines = RegionalInvoiceLines;
        return this;
    }

}