package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.CustomerDao;
import gov.iti.jets.persistence.dto.customer.CustomerListDto;
import gov.iti.jets.persistence.dto.staff.StaffListDto;
import gov.iti.jets.persistence.views.CustomerList;
import gov.iti.jets.persistence.views.StaffList;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CustomerListMapper;
import gov.iti.jets.service.util.mapper.StaffListMapper;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.*;

public class CustomerImpl implements CustomerDao {
    EntityManagerLoaner entityManagerLoaner;

    public CustomerImpl() {
        entityManagerLoaner =new EntityManagerLoaner();
    }
    // check whether the customer has an outstanding balance
    @Override
    public BigDecimal getcustomerBalanceInspecificDate(EntityManager entityManager,Integer customerId, Date date) throws validationException {
        String SqlQuery = "SELECT get_customer_balance(:id,:date) from DUAL";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",customerId);
        map.put("date",date);

        BigDecimal amount = entityManagerLoaner.execute(entityManager,new TransactionImpl<>(BigDecimal.class), SqlQuery, map);
        return  amount;
    }

    @Override
    public List<CustomerListDto> getCustomersList(EntityManager entityManager, Page page) throws validationException {
        String SQLStr ="From CustomerList Cl";
        List<CustomerList> customerLists = entityManagerLoaner.executeList(entityManager,new TransactionImpl<>(CustomerList.class),SQLStr,new HashMap<>(),page);
        List<CustomerListDto> customerListDtos =new ArrayList<>();
        customerLists.forEach(customerList -> {
            customerListDtos.add(CustomerListMapper.INSTANCE.customerListToCustomerListDto(customerList));
        });
        return  customerListDtos;
    }


}
