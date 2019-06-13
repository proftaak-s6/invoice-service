package services;

import java.io.ByteArrayInputStream;

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
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

import models.Address;
import models.Invoice;
import models.SupplierInformation;
import models.carservice.Car;
import models.trackservice.Step;
import services.pdfservicehelpers.*;
import services.interfaces.PdfService;

public class PdfServiceImpl implements PdfService {

    private ByteArrayOutputStream baos;
    private Document document;

    public PdfServiceImpl() {
        this.baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        this.document = new Document(pdf);
        this.document.setFontSize(11);
    }

    @Override
    public ByteArrayInputStream GenerateInvoicePdf(Invoice invoice) {
        this.AddTextboxParagraph(this.getSupplierInformation().toString(), 350, 610, 200);
        this.AddTitleImage();
        this.AddWhitelines(6);
        this.AddParagraph(invoice.getPersonalInformation().toString());
        this.AddWhitelines(2);
        this.AddChapterTitle("Factuur");
        this.AddInvoiceInformation(invoice);
        this.AddWhiteline();
        this.AddCarTables(invoice.getCars());
        this.AddChapterTitle("Totaal");
        this.AddTotalsTable(invoice);
        this.AddWhiteline();
        this.AddDisclaimer(invoice);

        document.close();

        return new ByteArrayInputStream(baos.toByteArray());
    }

    private void AddTitleImage() {
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
    }

    private void AddInvoiceInformation(Invoice invoice) {
        float[] pointColumnWidths = { 150F, 150F };
        Table table = new Table(pointColumnWidths);
        table.setStrokeColor(Color.WHITE);

        table.addCell("Factuurnummer: ");
        table.addCell("" + invoice.getPayment().getId());
        table.addCell("Factuurdatum: ");
        table.addCell(this.formatAsSimpleDate(invoice.getInvoiceDate()));

        this.document.add(table);
    }

    private void AddCarTables(List<Car> cars) {
        for (Car car : cars) {
            this.AddCarTable(car);
            this.AddPagebreak();

        }
    }

    private void AddCarTable(Car car) {
        String vehicleInfo = car.getBrand() + " " + car.getSeries() + ", " + car.getLicensePlateNumber();
        this.AddStyledParagraph(vehicleInfo, ITextStyle.H1);

        this.AddDrivenSteps(car);

        this.AddWhiteline();
    }

    private void AddDrivenSteps(Car car) {
        float[] pointColumnWidths = { 150F, 150F, 150F, 150F };
        Table table = new Table(pointColumnWidths);

        // Headers
        table.addCell(new Cell().add("Gereden weg").setBold());
        table.addCell(new Cell().add("Datum").setBold());
        table.addCell(new Cell().add("Afstand (m)").setBold());
        table.addCell(new Cell().add("Prijs ex. btw").setBold());

        // Content
        for (Step step : car.getDrivenSteps()) {
            Date stepDate = step.getLocations().get(0).date;

            table.addCell(step.getStart().getName());
            table.addCell(this.formatAsSimpleDate(stepDate));
            table.addCell(new Cell().add("" + step.getDistance()));
            table.addCell(this.createCurrencyCell(step.getPriceToPay()));
        }

        // Totals
        table.addCell(new Cell().add("Totaal").setBold());
        table.addCell("");
        table.addCell("");
        table.addCell(new Cell().add(this.createCurrencyCell(car.getTotalCostOfDrivenSteps())).setBold());

        this.document.add(table);
    }

    private void AddTotalsTable(Invoice invoice) {
        float[] pointColumnWidths = { 200F, 200F };
        Table table = new Table(pointColumnWidths);

        // Titles
        table.addCell(new Cell().add("Voertuig").setBold());
        table.addCell(new Cell().add("Totaal").setBold());

        // Car line
        for (Car car : invoice.getCars()) {
            String vehicleInfo = car.getBrand() + " " + car.getSeries() + ", " + car.getLicensePlateNumber();

            table.addCell(vehicleInfo);
            table.addCell(new Cell().add(this.createCurrencyCell(car.getTotalCostOfDrivenSteps())));
        }

        // Whiteline
        table.addCell("");
        table.addCell("");

        // Subtotals
        table.addCell("Subtotaal");
        table.addCell(new Cell().add(this.createCurrencyCell(invoice.getTotalCostOfCars())));

        // Taxes
        table.addCell("21,00% BTW");
        table.addCell(new Cell()
                .add(this.createCurrencyCell(invoice.getTotalCostOfCars().multiply(BigDecimal.valueOf(0.21)))));

        // Totals
        table.addCell(new Cell().add("Totaal").setBold());
        table.addCell(
                new Cell().add(this.createCurrencyCell(invoice.getTotalCostOfCars().multiply(BigDecimal.valueOf(1.21))))
                        .setBold());

        this.document.add(table);
    }

    private void AddDisclaimer(Invoice invoice) {
        BigDecimal costIncludingTaxes = invoice.getTotalCostOfCars().multiply(BigDecimal.valueOf(1.21));

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(2);
        String moneyString = formatter.format(costIncludingTaxes);

        this.AddParagraph("Wij verzoeken u vriendelijk om het bovenstaande bedrag van " + moneyString
                + "  op onze bankrekening te voldoen, onder vermelding van het factuurnummer "
                + invoice.getPayment().getId() + ".");
    }

    // #region General reusable methods
    private void AddParagraph(String text) {
        this.AddStyledParagraph(text, ITextStyle.P);
    }

    private void AddStyledParagraph(String text, ITextStyle textStyle) {
        Text styledKilometers = new Text(text).addStyle(ITextPdfStyler.GetStyle(textStyle));
        this.document.add(new Paragraph(styledKilometers));
    }

    private void AddTextboxParagraph(String text, float xPosition, float yPosition, int width) {
        Paragraph paragraph = new Paragraph(text);

        paragraph.setFixedPosition(xPosition, yPosition, width);
        paragraph.setTextAlignment(TextAlignment.RIGHT);
        paragraph.setBorder(new SolidBorder(1));
        paragraph.setPadding(10f);

        this.document.add(paragraph);
    }

    private void AddWhiteline() {
        Paragraph paragraph = new Paragraph("\n");
        paragraph.setMargin(0f);
        this.document.add(paragraph);
    }

    private void AddWhitelines(int amountOfLines) {
        for (int i = 0; i < amountOfLines; i++) {
            this.AddWhiteline();
        }
    }

    private void AddPagebreak() {
        document.add(new AreaBreak());
    }

    private void AddChapterTitle(String text) {
        Text styledText = new Text(text).addStyle(ITextPdfStyler.GetStyle(ITextStyle.H1));
        Paragraph paragraph = new Paragraph(styledText);

        this.document.add(paragraph);
    }
    // #region

    // #region Helpers
    private Cell createCurrencyCell(double value) {
        return this.createCurrencyCell(BigDecimal.valueOf(value));
    }

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

    private SupplierInformation getSupplierInformation() {
        return new SupplierInformation("Rekeningrijden",
                new Address("Professor Goossenslaan", "1", "5022DM", "Tilburg", "The Netherlands"), "NL123456789B01",
                "123456789", "NL21ABNA0123456789");
    }
    // #region
}