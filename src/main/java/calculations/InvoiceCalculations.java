package calculations;

import java.math.BigDecimal;

import models.*;

public class InvoiceCalculations {

    // #region Invoice
    public static BigDecimal getCostBeforeTaxes(Invoice invoice) {
        BigDecimal total = new BigDecimal(0);

        for (VehicleInvoice vi : invoice.getVehicleInvoices()) {
            total = total.add(VehicleInvoiceCalculations.getCostBeforeTaxes(vi));
        }

        return total;
    }

    public static BigDecimal getAccountedTaxes(Invoice invoice) {
        return InvoiceCalculations.getCostIncludingTaxes(invoice)
                .subtract(InvoiceCalculations.getCostBeforeTaxes(invoice));
    }

    public static BigDecimal getCostIncludingTaxes(Invoice invoice) {
        return InvoiceCalculations.getCostBeforeTaxes(invoice).multiply(new BigDecimal(1.21));
    }
    // #endregion Invoice
}

