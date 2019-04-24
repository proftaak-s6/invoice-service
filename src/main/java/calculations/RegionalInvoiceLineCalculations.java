package calculations;

import java.math.BigDecimal;
import java.math.MathContext;

import models.*;


public class RegionalInvoiceLineCalculations {

    // #region RegionalInvoiceLine
    public static BigDecimal getCostBeforeTaxes(RegionalInvoiceLine regionalInvoiceLine) {
        return regionalInvoiceLine.getAccountedPriceBeforeTaxes().round(new MathContext(2));
    }
    // #endregion RegionalInvoice
}