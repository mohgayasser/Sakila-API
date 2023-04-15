package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.customerDao;
import gov.iti.jets.persistence.entity.Customer;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.Date;

public class customerImpl extends RepositoryImpl<Customer,Integer> implements customerDao {
    public customerImpl() {
        super(Customer.class);
    }


    // check whether the customer has an outstanding balance
    @Override
    public BigDecimal getcustomerBalanceInspecificDate(Integer customerId, Date date) {
        String SqlQuery = "SELECT get_customer_balance(:id,:date) from DUAL";
        Query query = _entityManager.createNativeQuery(SqlQuery);
        query.setParameter("id",customerId);
        query.setParameter("date",date);

        BigDecimal amount = (BigDecimal) query.getSingleResult();
        return  amount;
    }


}
