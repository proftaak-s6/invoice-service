package calculations;

import java.math.BigDecimal;
import java.util.List;

import models.*;

public class KilometerInvoiceCalculations {
    public static BigDecimal getCostBeforeTaxes(List<KilometerInvoiceLine> KilometerInvoiceLines) {
        BigDecimal total = new BigDecimal(0);

        for (KilometerInvoiceLine kil : KilometerInvoiceLines) {
            total = total.add(KilometerInvoiceLineCalculations.getCostBeforeTaxes(kil));
        }

        return total;
    }
}