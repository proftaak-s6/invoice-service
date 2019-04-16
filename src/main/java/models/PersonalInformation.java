package models;

public class PersonalInformation {
    public String fullname;
    public Address address;

    public PersonalInformation() {
    }

    public PersonalInformation(String fullname, Address address) {
        this.fullname = fullname;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.fullname + " \n" + this.address.Streetname + " " + this.address.Housenumber + " \n"
                + this.address.Zipcode + " " + this.address.City + " \n" + this.address.Country;
    }
    
    // Getters and setters
    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonalInformation fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public PersonalInformation address(Address address) {
        this.address = address;
        return this;
    }

}