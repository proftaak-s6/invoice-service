package models.carservice;

import java.util.Date;

public class Tracker {
    private long id;
    private String manufacturer;
    private Date activationDate;

    public Tracker() {
    }

    public Tracker(long id, String manufacturer, Date activationDate) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.activationDate = activationDate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", manufacturer='" + getManufacturer() + "'" + ", activationDate='"
                + getActivationDate() + "'" + "}";
    }

}
