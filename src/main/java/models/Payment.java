package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Month;

@Entity
public class Payment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private long brpId;
    private Month month;
    private int year;
    private boolean isPaid;

    public Payment() {
    }

    public Payment(long id, long brpId, Month month, int year, boolean isPaid) {
        this.id = id;
        this.brpId = brpId;
        this.month = month;
        this.year = year;
        this.isPaid = isPaid;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "{" + " id='" + getId() + "'" + ", brpId='" + getBrpId() + "'" + ", month='" + getMonth() + "'"
                + ", year='" + getYear() + "'" + ", isPaid='" + isIsPaid() + "'" + "}";
    }

}
