package models;

public class Address {
    public String Streetname;
    public String Housenumber;
    public String Zipcode;
    public String City;
    public String Country;

    public Address() {
    }

    public Address(String Streetname, String Housenumber, String Zipcode, String City, String Country) {
        this.Streetname = Streetname;
        this.Housenumber = Housenumber;
        this.Zipcode = Zipcode;
        this.City = City;
        this.Country = Country;
    }

    @Override
    public String toString(){
        return this.Streetname + " " + this.Housenumber + " \n" + 
        this.Zipcode + " " + this.City + " \n" + 
        this.Country + " \n";
    }

    // Getters and setters
    public String getStreetname() {
        return this.Streetname;
    }

    public void setStreetname(String Streetname) {
        this.Streetname = Streetname;
    }

    public String getHousenumber() {
        return this.Housenumber;
    }

    public void setHousenumber(String Housenumber) {
        this.Housenumber = Housenumber;
    }

    public String getZipcode() {
        return this.Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

}