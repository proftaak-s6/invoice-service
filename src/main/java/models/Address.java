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

}