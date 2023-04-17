package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.dto.customer.CustomerListDto;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CustomerDao {
    public BigDecimal getcustomerBalanceInspecificDate(EntityManager entityManager,Integer customerId, Date date) throws validationException;
    public List<CustomerListDto> getCustomersList(EntityManager entityManager, Page page) throws validationException;
//    public Double subtractFromCustomerBalance(Integer customerId,Double amount);
}
