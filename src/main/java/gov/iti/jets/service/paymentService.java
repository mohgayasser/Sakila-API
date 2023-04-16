package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.paymentImpl;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.service.util.exceptions.validationException;

public class paymentService {
    paymentImpl paymentimp = new paymentImpl();
    EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();
    public Payment newPayment(Payment customerPayment) throws validationException {
        Payment payment =entityManagerLoaner.executeCRUD(new TransactionImpl<>(Payment.class),customerPayment,"create");

        return payment;

    }
    public Payment updatePayment(Payment payment) throws validationException {
        Payment updatedPayment = entityManagerLoaner.executeCRUD(new TransactionImpl<>(Payment.class),payment,"update");
        return payment;
    }
}
