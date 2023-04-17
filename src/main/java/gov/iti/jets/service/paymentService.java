package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.EntityManagerOperationsProxy;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dao.paymentImpl;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

public class paymentService {
    paymentImpl paymentimp = new paymentImpl();
    EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();
    private final EntityManagerOperations entityManagerOperations;
    public paymentService(){
        entityManagerOperations = new EntityManagerOperationsProxy();
    }
    public Payment newPayment(EntityManager entityManager,Payment customerPayment) throws validationException {
        Payment payment =entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Payment.class),customerPayment,"create");

        return payment;

    }
    public Payment updatePayment(EntityManager entityManager,Payment payment) throws validationException {
        Payment updatedPayment = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Payment.class),payment,"update");

        return payment;
    }
}
