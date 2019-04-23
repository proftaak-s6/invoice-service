package models;

import java.math.BigDecimal;
import java.util.List;

public class RegionalInvoice {
    private BigDecimal totalPriceBeforeTaxes;
    private List<RegionalInvoiceLine> regionalInvoiceLines;

    public RegionalInvoice() {
    }

    public RegionalInvoice(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.regionalInvoiceLines = RegionalInvoiceLines;
        this.totalPriceBeforeTaxes = calculatePriceBeforeTaxes();
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        BigDecimal total = new BigDecimal(0);

        for (RegionalInvoiceLine ril : this.regionalInvoiceLines) {
            total = total.add(ril.calculatePriceBeforeTaxes());
        }

        return total;
    }

    public RegionalInvoice(BigDecimal TotalPriceBeforeTaxes, List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.totalPriceBeforeTaxes = TotalPriceBeforeTaxes;
        this.regionalInvoiceLines = RegionalInvoiceLines;
    }

    public BigDecimal getTotalPriceBeforeTaxes() {
        return this.totalPriceBeforeTaxes;
    }

    public void setTotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.totalPriceBeforeTaxes = TotalPriceBeforeTaxes;
    }

    // Getters and setters
    public List<RegionalInvoiceLine> getRegionalInvoiceLines() {
        return this.regionalInvoiceLines;
    }

    public void setRegionalInvoiceLines(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.regionalInvoiceLines = RegionalInvoiceLines;
    }

    public RegionalInvoice TotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.totalPriceBeforeTaxes = TotalPriceBeforeTaxes;
        return this;
    }

    public RegionalInvoice RegionalInvoiceLines(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        this.regionalInvoiceLines = RegionalInvoiceLines;
        return this;
    }

}