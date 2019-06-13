package services.interfaces;

import java.time.Month;

import models.Payment;

public interface PaymentService extends BaseService<Payment> {
    Payment createIfNew(String bsn, int year, Month month);
}
