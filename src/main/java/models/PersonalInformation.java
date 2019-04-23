package models;

public class PersonalInformation {
    private String fullname;
    private Address address;

    public PersonalInformation() {
    }

    public PersonalInformation(String fullname, Address address) {
        this.fullname = fullname;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.fullname + " \n" + this.address.getStreetname() + " " + this.address.getHousenumber() + " \n"
                + this.address.getZipcode() + " " + this.address.getCity() + " \n" + this.address.getCountry();
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