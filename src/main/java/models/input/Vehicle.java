package models.input;

public class Vehicle {
    private String displayName;
    private String licensePlate;

    public Vehicle() {
    }


    public Vehicle(String displayName, String licensePlate, int massWeight) {
        this.displayName = displayName;
        this.licensePlate = licensePlate;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}