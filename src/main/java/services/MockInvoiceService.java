package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import models.Address;
import models.Invoice;
import models.KilometerInvoiceLine;
import models.PersonalInformation;
import models.RegionalInvoiceLine;
import models.RoadType;
import models.SupplierInformation;
import models.VehicleInvoice;

@ApplicationScoped
public class MockInvoiceService {

        public Invoice GenerateMockInvoice() {
                Date today = new Date();
                String invoiceNumber = (today.getYear() + 1900) + "0" + today.getMonth() + "00" + today.getHours() + ""
                                + today.getMinutes() + "" + today.getSeconds();
                Date invoiceDate = new Date(119, 04, 02);
                Invoice invoice = new Invoice(invoiceNumber, invoiceDate, GeneratePersonalInformation(),
                                GenerateSupplierInformation(), GenerateVehicleInvoices());
                return invoice;
        }

        private PersonalInformation GeneratePersonalInformation() {
                return new PersonalInformation("Jacques de Roij",
                                new Address("Hertogensingel", "31", "5341AB", "Oss", "The Netherlands"));
        }

        private SupplierInformation GenerateSupplierInformation() {
                return new SupplierInformation("Rekeningrijden",
                                new Address("Professor Goossenslaan", "1", "5022DM", "Tilburg", "The Netherlands"),
                                "NL123456789B01", "123456789", "NL21ABNA0123456789");
        }

        private static List<RegionalInvoiceLine> GenerateRegionalInvoiceOpelCorsa() {
                List<RegionalInvoiceLine> regionalInvoiceLines = new ArrayList<RegionalInvoiceLine>();

                regionalInvoiceLines.add(new RegionalInvoiceLine("Tilburg", new Date(119, 03, 01, 8, 42),
                                new BigDecimal(1.95), new BigDecimal(1.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Eindhoven", new Date(119, 03, 01, 12, 01),
                                new BigDecimal(3.95), new BigDecimal(3.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Tilburg", new Date(119, 03, 01, 17, 51),
                                new BigDecimal(4.95), new BigDecimal(0)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Tilburg", new Date(119, 03, 02, 8, 32),
                                new BigDecimal(1.95), new BigDecimal(1.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Den Bosch", new Date(119, 03, 02, 9, 26),
                                new BigDecimal(2.95), new BigDecimal(2.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Den Bosch", new Date(119, 03, 02, 19, 26),
                                new BigDecimal(2.95), new BigDecimal(0)));

                return regionalInvoiceLines;
        }

        private static List<KilometerInvoiceLine> GenerateKilometerInvoiceOpelCorsa() {
                List<KilometerInvoiceLine> kilometerInvoiceLines = new ArrayList<KilometerInvoiceLine>();
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.A, 830000, new BigDecimal(0.005)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.B, 34000, new BigDecimal(0.003)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.C, 12500, new BigDecimal(0.002)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.D, 8000, new BigDecimal(0.001)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.E, 4000, new BigDecimal(0.000)));

                return kilometerInvoiceLines;
        }

        private static List<RegionalInvoiceLine> GenerateRegionalInvoicesVolkswagenPolo() {
                List<RegionalInvoiceLine> regionalInvoiceLines = new ArrayList<RegionalInvoiceLine>();

                regionalInvoiceLines.add(new RegionalInvoiceLine("Tilburg", new Date(119, 03, 01, 8, 42),
                                new BigDecimal(1.95), new BigDecimal(1.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Eindhoven", new Date(119, 03, 01, 12, 01),
                                new BigDecimal(3.95), new BigDecimal(3.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Tilburg", new Date(119, 03, 01, 17, 51),
                                new BigDecimal(4.95), new BigDecimal(0)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Tilburg", new Date(119, 03, 02, 8, 32),
                                new BigDecimal(1.95), new BigDecimal(1.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Den Bosch", new Date(119, 03, 02, 9, 26),
                                new BigDecimal(2.95), new BigDecimal(2.95)));
                regionalInvoiceLines.add(new RegionalInvoiceLine("Den Bosch", new Date(119, 03, 02, 19, 26),
                                new BigDecimal(2.95), new BigDecimal(0)));

                return regionalInvoiceLines;
        }

        private static List<KilometerInvoiceLine> GenerateKilometerInvoiceVolkswagenPolo() {
                List<KilometerInvoiceLine> kilometerInvoiceLines = new ArrayList<KilometerInvoiceLine>();
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.A, 1030000, new BigDecimal(0.005)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.B, 664000, new BigDecimal(0.003)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.C, 18500, new BigDecimal(0.002)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.D, 8500, new BigDecimal(0.001)));
                kilometerInvoiceLines.add(new KilometerInvoiceLine(RoadType.E, 4200, new BigDecimal(0.000)));

                return kilometerInvoiceLines;
        }

        private static List<VehicleInvoice> GenerateVehicleInvoices() {
                // VehicleInvoice opelCorsa = new VehicleInvoice("Opel Corsa", "32-LP-VV",
                //                 GenerateRegionalInvoiceOpelCorsa(), GenerateKilometerInvoiceOpelCorsa());
                // VehicleInvoice volkswagenGolf = new VehicleInvoice("Volkswagen Polo", "TD-NR-98",
                //                 GenerateRegionalInvoicesVolkswagenPolo(), GenerateKilometerInvoiceVolkswagenPolo());
                List<VehicleInvoice> vehicleInvoices = new ArrayList<VehicleInvoice>();
                // vehicleInvoices.add(opelCorsa);
                // vehicleInvoices.add(volkswagenGolf);

                return vehicleInvoices;
        }
}