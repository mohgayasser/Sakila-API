package gov.iti.jets.service.customer;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.service.interfaces.customerService;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CustomerMapper;

import java.util.Optional;

public class getCustomerService implements customerService {
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
}
