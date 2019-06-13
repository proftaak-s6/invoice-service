package models.trackservice;

public class NamedLocation extends Location {

    private String name;

    public NamedLocation() {
    }

    public NamedLocation(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", lat='" + getLat() + "'" + ", lng='" + getLng() + "'" + "}";
    }

}