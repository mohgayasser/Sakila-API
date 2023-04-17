package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Date;

public interface customerDao {
    public BigDecimal getcustomerBalanceInspecificDate(EntityManager entityManager,Integer customerId, Date date) throws validationException;
//    public Double subtractFromCustomerBalance(Integer customerId,Double amount);
}
