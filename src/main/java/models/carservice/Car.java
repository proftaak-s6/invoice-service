package models.carservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import models.trackservice.Step;

public class Car {

    private long id;
    private long ownerId;
    private List<OwnershipHistory> ownershipHistoryList = new ArrayList<>();
    private String licensePlateNumber;
    private String brand;
    private String series;
    private String vehicleType;
    private String engineType;
    private String fuelType;
    private String energyLabel;
    private Tracker tracker;
    private List<Step> drivenSteps;

    public BigDecimal getTotalCostOfDrivenSteps() {
        BigDecimal total = new BigDecimal(0);

        for (Step step : drivenSteps) {
            total = total.add(BigDecimal.valueOf(step.getPriceToPay()));
        }

        return total;
    }

    public Car() {
    }

    public Car(long id, long ownerId, List<OwnershipHistory> ownershipHistoryList, String licensePlateNumber,
            String brand, String series, String vehicleType, String engineType, String fuelType, String energyLabel,
            Tracker tracker, List<Step> drivenSteps) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownershipHistoryList = ownershipHistoryList;
        this.licensePlateNumber = licensePlateNumber;
        this.brand = brand;
        this.series = series;
        this.vehicleType = vehicleType;
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.energyLabel = energyLabel;
        this.tracker = tracker;
        this.drivenSteps = drivenSteps;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public List<OwnershipHistory> getOwnershipHistoryList() {
        return this.ownershipHistoryList;
    }

    public void setOwnershipHistoryList(List<OwnershipHistory> ownershipHistoryList) {
        this.ownershipHistoryList = ownershipHistoryList;
    }

    public String getLicensePlateNumber() {
        return this.licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEnergyLabel() {
        return this.energyLabel;
    }

    public void setEnergyLabel(String energyLabel) {
        this.energyLabel = energyLabel;
    }

    public Tracker getTracker() {
        return this.tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public List<Step> getDrivenSteps() {
        return this.drivenSteps;
    }

    public void setDrivenSteps(List<Step> drivenSteps) {
        this.drivenSteps = drivenSteps;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", ownerId='" + getOwnerId() + "'" + ", ownershipHistoryList='"
                + getOwnershipHistoryList() + "'" + ", licensePlateNumber='" + getLicensePlateNumber() + "'"
                + ", brand='" + getBrand() + "'" + ", series='" + getSeries() + "'" + ", vehicleType='"
                + getVehicleType() + "'" + ", engineType='" + getEngineType() + "'" + ", fuelType='" + getFuelType()
                + "'" + ", energyLabel='" + getEnergyLabel() + "'" + ", tracker='" + getTracker() + "'"
                + ", drivenSteps='" + getDrivenSteps() + "'" + "}";
    }

}
