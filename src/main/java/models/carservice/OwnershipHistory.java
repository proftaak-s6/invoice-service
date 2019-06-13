package models.carservice;

import java.util.Date;

public class OwnershipHistory {

    private long id;
    private Car car;
    private long OwnerId;
    private Date startDate;
    private Date endDate;

    public OwnershipHistory() {
    }

    public OwnershipHistory(long id, Car car, long OwnerId, Date startDate, Date endDate) {
        this.id = id;
        this.car = car;
        this.OwnerId = OwnerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getOwnerId() {
        return this.OwnerId;
    }

    public void setOwnerId(long OwnerId) {
        this.OwnerId = OwnerId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", car='" + getCar() + "'" + ", OwnerId='" + getOwnerId() + "'"
                + ", startDate='" + getStartDate() + "'" + ", endDate='" + getEndDate() + "'" + "}";
    }

}
