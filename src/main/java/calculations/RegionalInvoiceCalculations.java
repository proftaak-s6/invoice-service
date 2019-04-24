package calculations;

import java.math.BigDecimal;
import java.util.List;

import models.*;

public class RegionalInvoiceCalculations {
    // #region VehicleInvoice
    public static BigDecimal getCostBeforeTaxes(List<RegionalInvoiceLine> RegionalInvoiceLines) {
        BigDecimal total = new BigDecimal(0);

        for (RegionalInvoiceLine ril : RegionalInvoiceLines) {
            total = total.add(RegionalInvoiceLineCalculations.getCostBeforeTaxes(ril));
        }

        return total;
    }

    public static BigDecimal getKilometerCostBeforeTaxes(VehicleInvoice vehicleInvoice) {
        BigDecimal total = new BigDecimal(0);

        for (KilometerInvoiceLine kil : vehicleInvoice.getKilometerInvoiceLines()) {
            total = total.add(KilometerInvoiceLineCalculations.getCostBeforeTaxes(kil));
        }

        return total;
    }
    // #endregion
}