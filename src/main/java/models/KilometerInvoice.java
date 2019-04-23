package models;

import java.math.BigDecimal;
import java.util.List;

public class KilometerInvoice {

    private List<KilometerInvoiceLine> kilometerInvoiceLines;
    private BigDecimal totalPriceBeforeTaxes;

    public KilometerInvoice() {
    }

    public KilometerInvoice(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        this.kilometerInvoiceLines = KilometerInvoiceLines;
        this.totalPriceBeforeTaxes = this.calculatePriceBeforeTaxes();
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        BigDecimal total = new BigDecimal(0);

        for (KilometerInvoiceLine kil : this.kilometerInvoiceLines) {
            total = total.add(kil.calculatePriceBeforeTaxes());
        }

        return total;
    }


    public KilometerInvoice(List<KilometerInvoiceLine> KilometerInvoiceLines, BigDecimal TotalPriceBeforeTaxes) {
        this.kilometerInvoiceLines = KilometerInvoiceLines;
        this.totalPriceBeforeTaxes = TotalPriceBeforeTaxes;
    }

    // Getters and setters
    public List<KilometerInvoiceLine> getKilometerInvoiceLines() {
        return this.kilometerInvoiceLines;
    }

    public void setKilometerInvoiceLines(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        this.kilometerInvoiceLines = KilometerInvoiceLines;
    }

    public BigDecimal getTotalPriceBeforeTaxes() {
        return this.totalPriceBeforeTaxes;
    }

    public void setTotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.totalPriceBeforeTaxes = TotalPriceBeforeTaxes;
    }

    public KilometerInvoice KilometerInvoiceLines(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        this.kilometerInvoiceLines = KilometerInvoiceLines;
        return this;
    }

    public KilometerInvoice TotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.totalPriceBeforeTaxes = TotalPriceBeforeTaxes;
        return this;
    }

}