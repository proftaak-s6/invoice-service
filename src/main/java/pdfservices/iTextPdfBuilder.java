package pdfservices;

import com.itextpdf.io.source.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import calculations.*;
import models.Invoice;
import models.KilometerInvoiceLine;
import models.RegionalInvoiceLine;
import models.VehicleInvoice;

public class iTextPdfBuilder {

    private ByteArrayOutputStream baos;
    private Document document;

    public iTextPdfBuilder() {
        this.baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        this.document = new Document(pdf);
        this.document.setFontSize(11);
    }

    public ByteArrayOutputStream Construct(Invoice invoice) {
        this.AddTextboxParagraph(invoice.getSupplierInformation().toString(), 350, 610, 200);
        this.AddTitleImage();
        this.AddWhitelines(6);
        this.AddParagraph(invoice.getPersonalInformation().toString());
        this.AddWhitelines(2);
        this.AddChapterTitle("Factuur");
        this.AddInvoiceInformation(invoice).AddWhiteline();
        this.AddVehiclesTables(invoice.getVehicleInvoices());
        this.AddChapterTitle("Totaal").AddTotalsTable(invoice);
        this.AddWhiteline();
        this.AddDisclaimer(invoice);

        document.close();
        return this.baos;
    }

    private iTextPdfBuilder AddTitleImage() {
        try {
            String imagePath = "https://github.com/proftaak-s6/invoice-service/blob/master/images/header-rijksoverheid.png?raw=true";
            ImageData data = ImageDataFactory.create(imagePath);

            Image image = new Image(data);
            image.setHeight(75);
            image.setWidth(110);
            image.setFixedPosition(280, 766);

            document.add(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return this;
    }

    private iTextPdfBuilder AddParagraph(String text) {
        return this.AddStyledParagraph(text, ITextStyle.P);
    }

    private iTextPdfBuilder AddStyledParagraph(String text, ITextStyle textStyle) {
        Text styledKilometers = new Text(text).addStyle(ITextPdfStyler.GetStyle(textStyle));
        this.document.add(new Paragraph(styledKilometers));
        return this;
    }

    private iTextPdfBuilder AddTextboxParagraph(String text, float xPosition, float yPosition, int width) {
        Paragraph paragraph = new Paragraph(text);

        paragraph.setFixedPosition(xPosition, yPosition, width);
        paragraph.setTextAlignment(TextAlignment.RIGHT);
        paragraph.setBorder(new SolidBorder(1));
        paragraph.setPadding(10f);

        this.document.add(paragraph);
        return this;
    }

    private iTextPdfBuilder AddWhiteline() {
        Paragraph paragraph = new Paragraph("\n");
        paragraph.setMargin(0f);
        this.document.add(paragraph);
        return this;
    }

    private iTextPdfBuilder AddWhitelines(int amountOfLines) {
        for (int i = 0; i < amountOfLines; i++) {
            this.AddWhiteline();
        }
        return this;
    }

    private iTextPdfBuilder AddPagebreak() {
        document.add(new AreaBreak());
        return this;
    }

    private iTextPdfBuilder AddVehiclesTables(List<VehicleInvoice> vehicleInvoices) {
        for (VehicleInvoice vi : vehicleInvoices) {
            this.AddVehicleTable(vi);
            this.AddPagebreak();
        }

        return this;
    }

    private void AddVehicleTable(VehicleInvoice vehicleInvoice) {
        String vehicleInfo = vehicleInvoice.getVehicle().getDisplayName() + ", Kentekenplaat: " + vehicleInvoice.getVehicle().getLicensePlate();
        this.AddStyledParagraph(vehicleInfo, ITextStyle.H1);

        this.AddStyledParagraph("Regio's", ITextStyle.H2);
        this.AddVehicleRegionalInvoiceTable(vehicleInvoice.getRegionalInvoiceLines());

        this.AddWhiteline();

        this.AddStyledParagraph("Kilometers", ITextStyle.H2);
        this.AddVehicleKilometerInvoiceTable(vehicleInvoice.getKilometerInvoiceLines());
    }

    private void AddVehicleRegionalInvoiceTable(List<RegionalInvoiceLine> regionalInvoice) {
        float[] pointColumnWidths = { 150F, 150F, 150F, 150F };
        Table table = new Table(pointColumnWidths);

        // Headers
        table.addCell(new Cell().add("Regio").setBold());
        table.addCell(new Cell().add("Gemonitord op").setBold());
        table.addCell(new Cell().add("Regioprijs").setBold());
        table.addCell(new Cell().add("Prijs ex. btw").setBold());

        // Content
        for (RegionalInvoiceLine ril : regionalInvoice) {
            table.addCell(ril.getRegion());
            table.addCell(this.formatAsSimpleDate(ril.getRegistrationMoment()));
            table.addCell(this.createCurrencyCell(ril.getRegionalPriceBeforeTaxes()));
            table.addCell(this.createCurrencyCell(ril.getAccountedPriceBeforeTaxes()));
        }

        // Totals
        table.addCell(new Cell().add("Totaal").setBold());
        table.addCell("");
        table.addCell("");
        RegionalInvoiceCalculations.getCostBeforeTaxes(regionalInvoice);
        table.addCell(
                new Cell().add(this.createCurrencyCell(RegionalInvoiceCalculations.getCostBeforeTaxes(regionalInvoice)))
                        .setBold());

        this.document.add(table);
    }

    private void AddVehicleKilometerInvoiceTable(List<KilometerInvoiceLine> kilometerInvoice) {
        float[] pointColumnWidths = { 150F, 150F, 150F, 150F };
        Table table = new Table(pointColumnWidths);

        // Headers
        table.addCell(new Cell().add("Wegtype").setBold());
        table.addCell(new Cell().add("Afstand (in kilometer)").setBold());
        table.addCell(new Cell().add("Prijs per kilometer").setBold());
        table.addCell(new Cell().add("Prijs ex. btw").setBold());

        // Content
        for (KilometerInvoiceLine kil : kilometerInvoice) {
            table.addCell(kil.getRoadType().toString());
            table.addCell(KilometerInvoiceLineCalculations.getDrivenDistanceInKilometers(kil).toString());
            table.addCell(this.createCurrencyCell(kil.getPricePerKilometerBeforeTaxes(), 8));
            table.addCell(this.createCurrencyCell(KilometerInvoiceLineCalculations.getCostBeforeTaxes(kil)));
        }

        // Totals
        table.addCell(new Cell().add("Totaal").setBold());
        table.addCell("");
        table.addCell("");

        table.addCell(new Cell().add(
                this.createCurrencyCell(KilometerInvoiceCalculations.getCostBeforeTaxes(kilometerInvoice)).setBold()));

        this.document.add(table);
    }

    private iTextPdfBuilder AddChapterTitle(String text) {
        Text styledText = new Text(text).addStyle(ITextPdfStyler.GetStyle(ITextStyle.H1));
        Paragraph paragraph = new Paragraph(styledText);

        this.document.add(paragraph);
        return this;
    }

    private iTextPdfBuilder AddInvoiceInformation(Invoice invoice) {
        float[] pointColumnWidths = { 150F, 150F };
        Table table = new Table(pointColumnWidths);
        table.setStrokeColor(Color.WHITE);

        table.addCell("Factuurnummer: ");
        table.addCell(invoice.getInvoiceNumberString());
        table.addCell("Factuurdatum: ");
        table.addCell(this.formatAsSimpleDate(invoice.getInvoiceDate()));

        this.document.add(table);
        return this;
    }

    private iTextPdfBuilder AddTotalsTable(Invoice invoice) {
        float[] pointColumnWidths = { 200F, 200F, 200F };
        Table table = new Table(pointColumnWidths);

        // Titles
        table.addCell(new Cell().add("Voertuig").setBold());
        table.addCell(new Cell().add("Kentekenplaat").setBold());
        table.addCell(new Cell().add("Totaal").setBold());

        // Car line
        for (VehicleInvoice vi : invoice.getVehicleInvoices()) {
            table.addCell(vi.getVehicle().getDisplayName());
            table.addCell(vi.getVehicle().getLicensePlate());
            table.addCell(new Cell().add(this.createCurrencyCell(VehicleInvoiceCalculations.getCostBeforeTaxes(vi))));
        }

        // Whiteline
        table.addCell("");
        table.addCell("");
        table.addCell("");

        // Subtotals
        table.addCell("");
        table.addCell("Subtotaal");
        table.addCell(new Cell().add(this.createCurrencyCell(InvoiceCalculations.getCostBeforeTaxes(invoice))));

        // Taxes
        table.addCell("");
        table.addCell("21,00% BTW");
        table.addCell(new Cell().add(this.createCurrencyCell(InvoiceCalculations.getAccountedTaxes(invoice))));

        // Totals
        table.addCell("");
        table.addCell(new Cell().add("Totaal").setBold());
        table.addCell(
                new Cell().add(this.createCurrencyCell(InvoiceCalculations.getCostIncludingTaxes(invoice))).setBold());

        this.document.add(table);

        return this;
    }

    private iTextPdfBuilder AddDisclaimer(Invoice invoice) {
        BigDecimal costIncludingTaxes = InvoiceCalculations.getCostIncludingTaxes(invoice);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(2);
        String moneyString = formatter.format(costIncludingTaxes);

        return this.AddParagraph("Wij verzoeken u vriendelijk om het bovenstaande bedrag van " + moneyString
                + "  op onze bankrekening te voldoen, onder vermelding van het factuurnummer 20190300000123.");
    }

    // #region Helpers
    private Cell createCurrencyCell(BigDecimal value) {
        return this.createCurrencyCell(value, 2);
    }

    private Cell createCurrencyCell(BigDecimal value, int precision) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(precision);
        String moneyString = formatter.format(value);

        Cell cell = new Cell().add(moneyString).setTextAlignment(TextAlignment.RIGHT);

        return cell;
    }

    private String formatAsSimpleDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    // #region
}