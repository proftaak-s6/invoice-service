package models;

import java.math.BigDecimal;
import java.util.List;

public class KilometerInvoice {

    public List<KilometerInvoiceLine> KilometerInvoiceLines;
    public BigDecimal TotalPriceBeforeTaxes;

    public KilometerInvoice() {
    }

    public KilometerInvoice(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        this.KilometerInvoiceLines = KilometerInvoiceLines;
        this.TotalPriceBeforeTaxes = this.calculatePriceBeforeTaxes();
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        BigDecimal total = new BigDecimal(0);

        for (KilometerInvoiceLine kil : this.KilometerInvoiceLines) {
            total = total.add(kil.calculatePriceBeforeTaxes());
        }

        return total;
    }


    public KilometerInvoice(List<KilometerInvoiceLine> KilometerInvoiceLines, BigDecimal TotalPriceBeforeTaxes) {
        this.KilometerInvoiceLines = KilometerInvoiceLines;
        this.TotalPriceBeforeTaxes = TotalPriceBeforeTaxes;
    }

    // Getters and setters
    public List<KilometerInvoiceLine> getKilometerInvoiceLines() {
        return this.KilometerInvoiceLines;
    }

    public void setKilometerInvoiceLines(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        this.KilometerInvoiceLines = KilometerInvoiceLines;
    }

    public BigDecimal getTotalPriceBeforeTaxes() {
        return this.TotalPriceBeforeTaxes;
    }

    public void setTotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.TotalPriceBeforeTaxes = TotalPriceBeforeTaxes;
    }

    public KilometerInvoice KilometerInvoiceLines(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        this.KilometerInvoiceLines = KilometerInvoiceLines;
        return this;
    }

    public KilometerInvoice TotalPriceBeforeTaxes(BigDecimal TotalPriceBeforeTaxes) {
        this.TotalPriceBeforeTaxes = TotalPriceBeforeTaxes;
        return this;
    }

}