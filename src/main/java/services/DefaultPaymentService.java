package services;

import models.Payment;
import services.interfaces.PaymentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DefaultPaymentService implements PaymentService {
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
    public Payment create(Payment model) {
        entityManager.persist(model);
        return model;
    }

    @Override
    public Payment update(Payment model) {
        entityManager.merge(model);
        return model;
    }

    @Override
    public boolean delete(long id) {
        Payment paymentToDelete = entityManager.find(Payment.class, id);
        entityManager.remove(paymentToDelete);
        return true;
    }
}
