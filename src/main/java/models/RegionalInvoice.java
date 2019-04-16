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

}