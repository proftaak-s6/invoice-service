package services;

import models.Payment;
import services.interfaces.PaymentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.Month;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment getById(long id) {
        return null;
    }

    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public Payment create(Payment model) {
        return null;
    }

    @Override
    public Payment update(Payment model) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Payment createIfNew(String bsn, int year, Month month) {
        return null;
    }
    
    // @PersistenceContext(unitName = "PU")
    // private EntityManager entityManager;

    // @Override
    // public Payment getById(long id) {
    // return entityManager.find(Payment.class, id);
    // }

    // @Override
    // public List<Payment> getAll() {
    // return entityManager.createQuery("SELECT p FROM Payment p",
    // Payment.class).getResultList();
    // }

    // @Override
    // @Transactional
    // public Payment create(Payment model) {
    // entityManager.persist(model);
    // return model;
    // }

    // @Override
    // @Transactional
    // public Payment update(Payment model) {
    // entityManager.merge(model);
    // return model;
    // }

    // @Override
    // @Transactional
    // public boolean delete(long id) {
    // Payment paymentToDelete = entityManager.find(Payment.class, id);
    // entityManager.remove(paymentToDelete);
    // return true;
    // }

    // @Override
    // public Payment createIfNew(String bsn, int year, Month month) {
    // // TODO!
    // return null;
    // }

}
