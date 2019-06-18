package services;

import models.Payment;
import services.interfaces.PaymentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.Month;
import java.util.List;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {

    @PersistenceContext(unitName = "PU")
    private EntityManager entityManager;

    @Override
    public Payment getById(long id) {
        return entityManager.find(Payment.class, id);
    }

    @Override
    public List<Payment> getAll() {
        return entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
    }

    @Override
    @Transactional
    public Payment create(Payment model) {
        entityManager.persist(model);
        return model;
    }

    @Override
    @Transactional
    public Payment update(Payment model) {
        entityManager.merge(model);
        return model;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Payment paymentToDelete = entityManager.find(Payment.class, id);
        entityManager.remove(paymentToDelete);
        return true;
    }

    @Override
    @Transactional
    public Payment createIfNew(String bsn, int year, Month month) {
        Optional<Payment> existingPayment = entityManager.createQuery("SELECT p FROM Payment p WHERE year = :year AND month = :month AND bsn LIKE :bsn", Payment.class)
            .setParameter("year", year)
            .setParameter("month", month)
            .setParameter("bsn", bsn)
            .setMaxResults(1)
            .getResultList()
            .stream()
            .findFirst();

        if (existingPayment.isPresent()) {
            return existingPayment.get();
        } 

        Payment newPayment = new Payment();
        newPayment.setBsn(bsn);
        newPayment.setMonth(month);
        newPayment.setYear(year);

        return create(newPayment);
    }
}
