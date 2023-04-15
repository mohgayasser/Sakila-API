package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.paymentDao;
import gov.iti.jets.persistence.entity.Payment;

public class paymentImpl extends RepositoryImpl<Payment,Integer> implements paymentDao {
    public paymentImpl(){
        super(Payment.class);
    }

}
