package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dao.paymentImpl;
import gov.iti.jets.persistence.dto.PaymentDto;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.service.util.mapper.PaymentMapper;

public class paymentService {
    paymentImpl paymentimp = new paymentImpl();
    RepositoryImpl<Payment, Integer> repo = new RepositoryImpl<>(Payment.class);
    public Payment newPayment(Payment customerPayment){
        Payment payment =repo.create(customerPayment);

        return payment;

    }
    public Payment updatePayment(Payment payment){
        Payment updatedPayment = repo.update(payment);
        return payment;
    }
}
