package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dao.customerImpl;
import gov.iti.jets.persistence.dto.RentalDto;
import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.customer.CustomerPaymentDto;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.presentation.dto.AddCustomerDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CustomerMapper;
import gov.iti.jets.service.util.mapper.CustomerPaymentMapper;
import gov.iti.jets.service.util.mapper.RentalMapper;

import java.math.BigDecimal;
import java.util.*;

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
    public Set<CustomerRentalDto> getCustomerRentalHistory(Integer customerId) throws validationException {
        Optional<Customer> customer =repo.findById(customerId);
        Set<Rental> rentalList =null;
        Set<CustomerRentalDto> rentalDtoList = new HashSet<>() ;
        if(customer.isPresent()){
            rentalList =  customer.get().getRentals();
            rentalList.forEach(rental -> {
                System.out.println("rental in loop ->"+rental);
                rentalDtoList.add(RentalMapper.INSTANCE.rentalToRentalDto(rental));
            });
        }else {
            throw new validationException("this Customer doesn't exist in our system");
        }
        return rentalDtoList;
    }
    public Set<CustomerPaymentDto> getCustomerPaymentHistory(Integer customerId) throws validationException {
        Optional<Customer> customer =repo.findById(customerId);
        Set<Payment> rentalList =null;
        Set<CustomerPaymentDto> rentalDtoList = new HashSet<>() ;
        if(customer.isPresent()){
            rentalList =  customer.get().getPayments();
            rentalList.forEach(payment -> {
                System.out.println("rental in loop ->"+payment);
                rentalDtoList.add(CustomerPaymentMapper.INSTANCE.paymentToCustomerPaymentDto(payment));
            });
        }else {
            throw new validationException("this Customer doesn't exist in our system");
        }
        return rentalDtoList;
    }
    //add customer service
    public boolean AddCustomer(AddCustomerDto customerDto){
        Customer customer = new Customer();

        return true;
    }
}
