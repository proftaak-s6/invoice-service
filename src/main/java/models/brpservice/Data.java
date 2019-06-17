package models.brpservice;

public class Data {
    private Person personByBsn;

    public Data() {
    }

    public Data(Person personByBsn) {
        this.personByBsn = personByBsn;
    }

    public Person getPersonByBsn() {
        return this.personByBsn;
    }

    public void setPersonByBsn(Person personByBsn) {
        this.personByBsn = personByBsn;
    }

    @Override
    public String toString() {
        return "{" + " personByBsn='" + getPersonByBsn() + "'" + "}";
    }

}