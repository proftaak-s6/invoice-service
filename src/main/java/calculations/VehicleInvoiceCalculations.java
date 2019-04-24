package calculations;

import java.math.BigDecimal;

import models.*;

public class VehicleInvoiceCalculations {
    public static BigDecimal getCostBeforeTaxes(VehicleInvoice vehicleInvoice) {
        BigDecimal regionalInvoiceCostBeforeTaxes = RegionalInvoiceCalculations
                .getCostBeforeTaxes(vehicleInvoice.getRegionalInvoiceLines());
        BigDecimal kilometerInvoiceCostBeforeTaxes = KilometerInvoiceCalculations
                .getCostBeforeTaxes(vehicleInvoice.getKilometerInvoiceLines());

        BigDecimal total = regionalInvoiceCostBeforeTaxes.add(kilometerInvoiceCostBeforeTaxes);
        return total;
    }
}