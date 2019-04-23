package models;

public class Address {
    private String streetname;
    private String housenumber;
    private String zipcode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String Streetname, String Housenumber, String Zipcode, String City, String Country) {
        this.streetname = Streetname;
        this.housenumber = Housenumber;
        this.zipcode = Zipcode;
        this.city = City;
        this.country = Country;
    }

    @Override
    public String toString(){
        return this.streetname + " " + this.housenumber + " \n" + 
        this.zipcode + " " + this.city + " \n" + 
        this.country + " \n";
    }

    // Getters and setters
    public String getStreetname() {
        return this.streetname;
    }

    public void setStreetname(String Streetname) {
        this.streetname = Streetname;
    }

    public String getHousenumber() {
        return this.housenumber;
    }

    public void setHousenumber(String Housenumber) {
        this.housenumber = Housenumber;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.zipcode = Zipcode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String City) {
        this.city = City;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String Country) {
        this.country = Country;
    }

}