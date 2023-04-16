package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.customerDao;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class customerImpl  implements customerDao {
    EntityManagerLoaner entityManagerLoaner;

    public customerImpl() {
        entityManagerLoaner =new EntityManagerLoaner();
    }
    // check whether the customer has an outstanding balance
    @Override
    public BigDecimal getcustomerBalanceInspecificDate(Integer customerId, Date date) throws validationException {
        String SqlQuery = "SELECT get_customer_balance(:id,:date) from DUAL";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",customerId);
        map.put("date",date);

        BigDecimal amount = entityManagerLoaner.execute(new TransactionImpl<>(BigDecimal.class), SqlQuery, map);
        return  amount;
    }


}
