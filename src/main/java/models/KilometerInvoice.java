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
}