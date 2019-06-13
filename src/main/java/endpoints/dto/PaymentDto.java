package endpoints.dto;

import models.Payment;

import java.time.Month;

public class PaymentDto {
    private String bsn;
    private Month month;
    private int year;
    private boolean isPaid;

    public Payment toModel(){
        Payment payment = new Payment();
        payment.setBsn(bsn);
        payment.setMonth(month);
        payment.setYear(year);
        payment.setIsPaid(isPaid);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
