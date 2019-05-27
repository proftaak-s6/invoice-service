package endpoints.dto;

import models.Payment;

import java.time.Month;
import java.time.Year;

public class PaymentDto {
    private String bsn;
    private Month month;
    private Year year;
    private boolean isPayed;

    public Payment toModel(){
        Payment payment = new Payment();
        payment.setBsn(bsn);
        payment.setMonth(month);
        payment.setYear(year);
        payment.setPayed(isPayed);
        return payment;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}
