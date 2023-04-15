package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dao.customerImpl;
import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CustomerMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class CustomerService {

    RepositoryImpl<Customer, Integer> repo = new RepositoryImpl<>(Customer.class);
    public CustomerDto getCustomerById(int customerId) throws validationException {
        Optional<Customer> customer =repo.findById(customerId);
        CustomerDto customerDto = null;
        if(customer.isPresent()) {
             customerDto = CustomerMapper.INSTANCE.customerToCustomerDto(customer.get());
        }else {
            throw new validationException("this Customer doesn't exist in our system");
        }
        return customerDto;
    }
    public BigDecimal getCustomerBalanceinSpecificDate(Integer customerId, Date date){
        customerImpl customer = new customerImpl();
        BigDecimal amount = customer.getcustomerBalanceInspecificDate(customerId,date);
        return amount;
    }
    public Customer updateCustomerBalance(Customer customer){
        Customer customer1 =repo.update(customer);
        return  customer1;
    }
}
