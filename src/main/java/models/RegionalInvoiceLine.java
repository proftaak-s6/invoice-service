package models;

import java.math.BigDecimal;
import java.util.Date;

public class RegionalInvoiceLine {
    private String region;
    private Date registrationMoment;
    private BigDecimal regionalPriceBeforeTaxes;
    private BigDecimal accountedPriceBeforeTaxes;

    public RegionalInvoiceLine() {
    }

    public RegionalInvoiceLine(String Region, Date RegistrationMoment, BigDecimal RegionalPriceBeforeTaxes,
            BigDecimal AccountedPriceBeforeTaxes) {
        this.region = Region;
        this.registrationMoment = RegistrationMoment;
        this.regionalPriceBeforeTaxes = RegionalPriceBeforeTaxes;
        this.accountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    // Getters and setters
    public String getRegion() {
        return this.region;
    }

    public void setRegion(String Region) {
        this.region = Region;
    }

    public Date getRegistrationMoment() {
        return this.registrationMoment;
    }

    public void setRegistrationMoment(Date RegistrationMoment) {
        this.registrationMoment = RegistrationMoment;
    }

    public BigDecimal getRegionalPriceBeforeTaxes() {
        return this.regionalPriceBeforeTaxes;
    }

    public void setRegionalPriceBeforeTaxes(BigDecimal RegionalPriceBeforeTaxes) {
        this.regionalPriceBeforeTaxes = RegionalPriceBeforeTaxes;
    }

    public BigDecimal getAccountedPriceBeforeTaxes() {
        return this.accountedPriceBeforeTaxes;
    }

    public void setAccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.accountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
    }

    public RegionalInvoiceLine Region(String Region) {
        this.region = Region;
        return this;
    }

    public RegionalInvoiceLine RegistrationMoment(Date RegistrationMoment) {
        this.registrationMoment = RegistrationMoment;
        return this;
    }

    public RegionalInvoiceLine RegionalPriceBeforeTaxes(BigDecimal RegionalPriceBeforeTaxes) {
        this.regionalPriceBeforeTaxes = RegionalPriceBeforeTaxes;
        return this;
    }

    public RegionalInvoiceLine AccountedPriceBeforeTaxes(BigDecimal AccountedPriceBeforeTaxes) {
        this.accountedPriceBeforeTaxes = AccountedPriceBeforeTaxes;
        return this;
    }
}