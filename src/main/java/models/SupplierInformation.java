package models;

public class SupplierInformation {
    String companyName;
    Address address = new Address();
    String BTWNumberString;
    String KVKNumberString;
    String IBANString;

    public SupplierInformation() {
    }

    public SupplierInformation(String CompanyName, Address Address, String BTWNumberString, String KVKNumberString,
            String IBANString) {
        this.companyName = CompanyName;
        this.address = Address;
        this.BTWNumberString = BTWNumberString;
        this.KVKNumberString = KVKNumberString;
        this.IBANString = IBANString;
    }

    @Override
    public String toString() {
        return this.companyName + " \n" + 
                this.address + " \n" + 
                "\n " + 
                "BTW nr.: " + this.BTWNumberString + " \n" + 
                "KvK nr.: " + this.KVKNumberString + " \n" + 
                "IBAN: " + this.IBANString;
    }


    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBTWNumberString() {
        return this.BTWNumberString;
    }

    public void setBTWNumberString(String BTWNumberString) {
        this.BTWNumberString = BTWNumberString;
    }

    public String getKVKNumberString() {
        return this.KVKNumberString;
    }

    public void setKVKNumberString(String KVKNumberString) {
        this.KVKNumberString = KVKNumberString;
    }

    public String getIBANString() {
        return this.IBANString;
    }

    public void setIBANString(String IBANString) {
        this.IBANString = IBANString;
    }

}