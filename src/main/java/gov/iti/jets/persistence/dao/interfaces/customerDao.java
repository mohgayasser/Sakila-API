package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.service.util.exceptions.validationException;

import java.math.BigDecimal;
import java.util.Date;

public interface customerDao {
    public BigDecimal getcustomerBalanceInspecificDate(Integer customerId, Date date) throws validationException;
//    public Double subtractFromCustomerBalance(Integer customerId,Double amount);
}
