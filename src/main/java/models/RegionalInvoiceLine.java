package models;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

public class RegionalInvoiceLine {
    public String Region;
    public Date RegistrationMoment;
    public BigDecimal RegionalPriceBeforeTaxes;
    public BigDecimal AccountedPriceBeforeTaxes;

    public RegionalInvoiceLine() {
    }

    public RegionalInvoiceLine(String Region, Date RegistrationMoment, BigDecimal RegionalPriceBeforeTaxes,
            BigDecimal AccountedPriceBeforeTaxes) {
        this.Region = Region;
        this.RegistrationMoment = RegistrationMoment;
        this.RegionalPriceBeforeTaxes = RegionalPriceBeforeTaxes;
        this.AccountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    public BigDecimal calculatePriceBeforeTaxes() {
        return AccountedPriceBeforeTaxes.round(new MathContext(2));
    }

    // Getters and setters
    public String getRegion() {
        return this.Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public Date getRegistrationMoment() {
        return this.RegistrationMoment;
    }

    public void setRegistrationMoment(Date RegistrationMoment) {
        this.RegistrationMoment = RegistrationMoment;
    }

    public BigDecimal getRegionalPriceBeforeTaxes() {
        return this.RegionalPriceBeforeTaxes;
    }

    public void setRegionalPriceBeforeTaxes(BigDecimal RegionalPriceBeforeTaxes) {
        this.RegionalPriceBeforeTaxes = RegionalPriceBeforeTaxes;
    }

    public BigDecimal getAccountedPriceBeforeTaxes() {
        return this.AccountedPriceBeforeTaxes;
    }

    public void setAccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.AccountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    public RegionalInvoiceLine Region(String Region) {
        this.Region = Region;
        return this;
    }

    public RegionalInvoiceLine RegistrationMoment(Date RegistrationMoment) {
        this.RegistrationMoment = RegistrationMoment;
        return this;
    }

    public RegionalInvoiceLine RegionalPriceBeforeTaxes(BigDecimal RegionalPriceBeforeTaxes) {
        this.RegionalPriceBeforeTaxes = RegionalPriceBeforeTaxes;
        return this;
    }

    public RegionalInvoiceLine AccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.AccountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
        return this;
    }
}