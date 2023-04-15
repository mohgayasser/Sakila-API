package gov.iti.jets.persistence.dao.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface customerDao {
    public BigDecimal getcustomerBalanceInspecificDate(Integer customerId, Date date);
//    public Double subtractFromCustomerBalance(Integer customerId,Double amount);
}
