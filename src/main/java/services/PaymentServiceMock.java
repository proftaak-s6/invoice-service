package services;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import models.Payment;
import services.interfaces.PaymentService;

public class PaymentServiceMock implements PaymentService {

    private List<Payment> payments = new ArrayList<>();

    private static long id = 0;

    @Override
    public Payment getById(long id) {
        for (Payment payment : this.payments) {
            if (payment.getId() == id) {
                return payment;
            }
        }

        return null;
    }

    @Override
    public List<Payment> getAll() {
        return payments;
    }

    @Override
    public Payment create(Payment model) {
        model.setId(id++);
        payments.add(model);
        return model;
    }

    @Override
    public Payment update(Payment model) {
        for (Payment payment : this.payments) {
            if (payment.getId() == model.getId()) {
                payment = model;
                return payment;
            }
        }

        return null;
    }

    @Override
    public boolean delete(long id) {
        for (Payment payment : this.payments) {
            if (payment.getId() == id) {
                payments.remove(payment);
                return true;
            }
        }
        return false;
    }

    @Override
    public Payment createIfNew(String bsn, int year, Month month) {
        for (Payment payment : this.payments) {
            if (payment.getBsn() == bsn && payment.getYear() == year && payment.getMonth().equals(month)) {
                return payment;
            }
        }

        Payment payment = new Payment(0, bsn, month, year, false);
        return this.create(payment);
    }

}