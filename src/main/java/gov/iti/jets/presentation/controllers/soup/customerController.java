package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.customer.CustomerPaymentDto;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.presentation.dto.AddCustomerDto;
import gov.iti.jets.presentation.dto.OperationalFilmDto;
import gov.iti.jets.service.CustomerService;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

@WebService(targetNamespace = "customers")
public class customerController {
    @WebMethod
    public CustomerDto getCustomerById(@WebParam(name = "customerId") int id ) throws  validationException {
        if (id < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            CustomerService getCustomerService = new CustomerService();
            CustomerDto customerDto = getCustomerService.getCustomerById(id);
            return  customerDto;

        }
    }
    @WebMethod
    public BigDecimal getcustomerBalanceInDate(@WebParam(name = "customerId") int id , @WebParam (name = "date") gov.iti.jets.service.util.models.Date date) throws  validationException {
        if (id < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(date.getYear(), date.getMonth(), date.getDay()).build();
            System.out.println("entered date ->" +cal.getTime());
            CustomerService getCustomerService = new CustomerService();
            BigDecimal amount = getCustomerService.getCustomerBalanceinSpecificDate(id, cal.getTime());
            return  amount;
        }
    }
    @WebMethod
    public Set<CustomerRentalDto> getCustomerRntalHistory(@WebParam(name = "customerId") Integer customerId) throws validationException {
        if(customerId <0){
            throw new validationException("you need to enter a valid id");

        }
        CustomerService customerService =new CustomerService();
        Set<CustomerRentalDto> rentalDtos =customerService.getCustomerRentalHistory(customerId);
        return  rentalDtos;
    }
    @WebMethod
    public Set<CustomerPaymentDto> getCustomerPaymentHistory(@WebParam(name = "customerId") Integer customerId) throws validationException {
        if(customerId <0){
            throw new validationException("you need to enter a valid id");

        }
        CustomerService customerService =new CustomerService();
        Set<CustomerPaymentDto> rentalDtos =customerService.getCustomerPaymentHistory(customerId);
        return  rentalDtos;
    }
    @WebMethod
    public  boolean newCustomer(@NotBlank@NotNull@WebParam(name = "customer")AddCustomerDto customerDto)throws validationException{
        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<AddCustomerDto>> violations = handler.getValidation().validate(customerDto);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        CustomerService customerService = new CustomerService();
        boolean result =customerService.AddCustomer(customerDto);
        return result;
    }
}
