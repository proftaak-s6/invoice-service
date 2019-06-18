package endpoints.dto;

import models.Payment;

import java.time.Month;

public class PaymentDto {
    private long brpId;
    private Month month;
    private int year;
    private boolean isPaid;

    public Payment toModel() {
        Payment payment = new Payment();
        payment.setBrpId(brpId);
        payment.setMonth(month);
        payment.setYear(year);
        payment.setIsPaid(isPaid);
        return payment;
    }

    public PaymentDto() {
    }

    public PaymentDto(long brpId, Month month, int year, boolean isPaid) {
        this.brpId = brpId;
        this.month = month;
        this.year = year;
        this.isPaid = isPaid;
    }

    public long getBrpId() {
        return this.brpId;
    }

    public void setBrpId(long brpId) {
        this.brpId = brpId;
    }

    public Month getMonth() {
        return this.month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isIsPaid() {
        return this.isPaid;
    }

    public boolean getIsPaid() {
        return this.isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "{" + " brpId='" + getBrpId() + "'" + ", month='" + getMonth() + "'" + ", year='" + getYear() + "'"
                + ", isPaid='" + isIsPaid() + "'" + "}";
    }

}
