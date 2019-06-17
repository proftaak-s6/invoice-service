package models.brpservice;

import models.Address;
import models.PersonalInformation;

public class Person {
    private String gegeven_naam;
    private String achternaam;
    private String straat;
    private String postcode;
    private String woonplaats;
    private String land;

    public PersonalInformation toPersonalInformation() {
        String fullname = gegeven_naam + " " + achternaam;

        String[] splitStreet = straat.split(" ");

        String housenumber = splitStreet[splitStreet.length - 1];
        splitStreet[splitStreet.length - 1] = "";

        String streetname = "";

        for (String split : splitStreet) {
            streetname += (split + "");
        }

        String zipcode = postcode;
        String city = woonplaats;
        
        String country = land;

        Address address = new Address(streetname, housenumber, zipcode, city, country);
        PersonalInformation personalInformation = new PersonalInformation(fullname, address);
        return personalInformation;
    }

    public Person() {
    }

    public Person(String gegeven_naam, String achternaam, String straat, String postcode, String woonplaats,
            String land) {
        this.gegeven_naam = gegeven_naam;
        this.achternaam = achternaam;
        this.straat = straat;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.land = land;
    }

    public String getGegeven_naam() {
        return this.gegeven_naam;
    }

    public void setGegeven_naam(String gegeven_naam) {
        this.gegeven_naam = gegeven_naam;
    }

    public String getAchternaam() {
        return this.achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getStraat() {
        return this.straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return this.woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getLand() {
        return this.land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public String toString() {
        return "{" + " gegeven_naam='" + getGegeven_naam() + "'" + ", achternaam='" + getAchternaam() + "'"
                + ", straat='" + getStraat() + "'" + ", postcode='" + getPostcode() + "'" + ", woonplaats='"
                + getWoonplaats() + "'" + ", land='" + getLand() + "'" + "}";
    }

}