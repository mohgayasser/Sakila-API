package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.*;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.customer.CustomerPaymentDto;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.presentation.models.AddCustomerDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CustomerMapper;
import gov.iti.jets.service.util.mapper.CustomerPaymentMapper;
import gov.iti.jets.service.util.mapper.RentalMapper;
import gov.iti.jets.service.util.mapper.newCustomerMapper;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.*;

public class CustomerService {
    private final EntityManagerOperations entityManagerOperations;

    EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();
public CustomerService(){
    entityManagerOperations =new EntityManagerOperationsProxy();
}
    public CustomerDto getCustomerById(int customerId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Optional<Customer> customer = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Customer.class),customerId,"find"));
        CustomerDto customerDto = null;
        if(customer.isPresent()) {
             customerDto = CustomerMapper.INSTANCE.customerToCustomerDto(customer.get());
        }else {
            throw new validationException("this Customer doesn't exist in our system");
        }
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return customerDto;
    }
    public BigDecimal getCustomerBalanceinSpecificDate(Integer customerId, Date date) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        customerImpl customer = new customerImpl();
        BigDecimal amount = customer.getcustomerBalanceInspecificDate(entityManager,customerId,date);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return amount;
    }
    public BigDecimal getCustomerBalanceinSpecificDateManaged(EntityManager entityManager, Integer customerId, Date date) throws validationException {

        customerImpl customer = new customerImpl();
        BigDecimal amount = customer.getcustomerBalanceInspecificDate(entityManager,customerId,date);

        return amount;
    }
    public Set<CustomerRentalDto> getCustomerRentalHistory(Integer customerId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Optional<Customer> customer = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Customer.class),customerId,"find"));
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
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return rentalDtoList;
    }
    public Set<CustomerPaymentDto> getCustomerPaymentHistory(Integer customerId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Optional<Customer> customer = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Customer.class),customerId,"find"));
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
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return rentalDtoList;
    }
    //add customer service
    public boolean AddCustomer(AddCustomerDto customerDto) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Customer customer = newCustomerMapper.INSTANCE.addCustomerDtoToCustomer(customerDto);

        StoreService storeService =new StoreService();
        Store store = null;
        try {
            store = storeService.getStoreById(customerDto.getStoreId());
        } catch (validationException e) {
            throw new validationException("this store id is wrong ");
        }
        customer.setStore(store);
        customer.setLastUpdate(new Date());
        customer.getAddress().setLastUpdate(new Date());
        CityImpl cityImpl =new CityImpl();

        Optional<City>  city = null;
        try {
            city = cityImpl.getCityByName(entityManager,customerDto.getAddress().getCity());
            if(city.isPresent()){
                customer.getAddress().setCity(city.get());
            }
        } catch (validationException e) {
            customer.getAddress().getCity().setLastUpdate(new Date());
        }

        CountryImpl countryImpl =new CountryImpl();
        Optional<Country>  country = null;
        try {
            country = countryImpl.getCountryByName(entityManager,customerDto.getAddress().getCountry());
            if(country.isPresent())
                customer.getAddress().getCity().setCountry(country.get());
        } catch (validationException e) {
            customer.getAddress().getCity().getCountry().setLastUpdate(new Date());
        }

        System.out.println("customer ->"+customer);
        customer.setActive(true);
        Customer addedCustomer=entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Customer.class),customer,"update");
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return true;
    }
}
