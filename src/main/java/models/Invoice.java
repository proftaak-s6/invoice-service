package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.carservice.Car;

public class Invoice {
    private Date invoiceDate;
    private PersonalInformation personalInformation;
    private Payment payment;
    private List<Car> cars;

    public BigDecimal getTotalCostOfCars() {
        BigDecimal total = new BigDecimal(0);

        for (Car car : cars) {
            total = total.add(car.getTotalCostOfDrivenSteps());
        }

        return total;
    }

    public Invoice() {
    }

    public Invoice(Date invoiceDate, PersonalInformation personalInformation, Payment payment, List<Car> cars) {
        this.invoiceDate = invoiceDate;
        this.personalInformation = personalInformation;
        this.payment = payment;
        this.cars = cars;
    }

    public Date getInvoiceDate() {
        return this.invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public PersonalInformation getPersonalInformation() {
        return this.personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "{" + " invoiceDate='" + getInvoiceDate() + "'" + ", personalInformation='" + getPersonalInformation()
                + "'" + ", payment='" + getPayment() + "'" + ", cars='" + getCars() + "'" + "}";
    }

}