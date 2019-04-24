package calculations;

import java.math.BigDecimal;
import java.math.MathContext;

import models.*;

public class KilometerInvoiceLineCalculations {
    // #region KilometerInvoiceLine
    public static BigDecimal getCostBeforeTaxes(KilometerInvoiceLine kilometerInvoiceLine) {
        return kilometerInvoiceLine.getPricePerKilometerBeforeTaxes()
                .multiply(new BigDecimal(kilometerInvoiceLine.getDrivenDistanceInMeters())).divide(new BigDecimal(1000))
                .round(new MathContext(2));
    }

    public static BigDecimal getDrivenDistanceInKilometers(KilometerInvoiceLine kilometerInvoiceLine) {
        return new BigDecimal(kilometerInvoiceLine.getDrivenDistanceInMeters()).divide(new BigDecimal(1000));
    }
    // #endregion
}