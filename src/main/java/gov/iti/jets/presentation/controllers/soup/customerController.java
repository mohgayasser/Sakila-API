package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.customer.CustomerListDto;
import gov.iti.jets.persistence.dto.customer.CustomerPaymentDto;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.presentation.models.AddCustomerDto;
import gov.iti.jets.presentation.models.Date;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.CustomerService;
import gov.iti.jets.service.util.customAnnotations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ConstraintViolation;
import org.geolatte.geom.builder.DSL;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@WebService(targetNamespace = "CustomerWebServer")
public class customerController {
    @WebMethod
    public CustomerDto getCustomerById(@WebParam(name = "customerId") Integer id ) throws  validationException {
        if (id==null||id < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            CustomerService getCustomerService = new CustomerService();
            CustomerDto customerDto = getCustomerService.getCustomerById(id);
            return  customerDto;

        }
    }
    @WebMethod
    public BigDecimal getcustomerBalanceInDate(@WebParam(name = "customerId") Integer id , @WebParam (name = "date") Date date) throws  validationException {
        if (id==null||id < 0) {
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
        if(customerId==null||customerId <0){
            throw new validationException("you need to enter a valid id");

        }
        CustomerService customerService =new CustomerService();
        Set<CustomerRentalDto> rentalDtos =customerService.getCustomerRentalHistory(customerId);
        return  rentalDtos;
    }
    @WebMethod
    public Set<CustomerPaymentDto> getCustomerPaymentHistory(@WebParam(name = "customerId") Integer customerId) throws validationException {
        if(customerId==null||customerId <0){
            throw new validationException("you need to enter a valid id");

        }
        CustomerService customerService =new CustomerService();
        Set<CustomerPaymentDto> rentalDtos =customerService.getCustomerPaymentHistory(customerId);
        return  rentalDtos;
    }
    @WebMethod
    public  boolean newCustomer(@WebParam(name = "customer")AddCustomerDto customerDto)throws validationException{
        String valid = ValidFieldsValidator.validate(customerDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        CustomerService customerService = new CustomerService();
        Integer result =customerService.AddCustomer(customerDto);
        return true;
    }
    @WebMethod
    public boolean deleteCustomer(@WebParam(name = "customerId")Integer customerId) throws validationException {
        if(customerId==null||customerId <0){
            throw new validationException("you need to enter a valid id starts from 1");
        }
        CustomerService customerService = new CustomerService();
        boolean result=customerService.softDelete(customerId);
        return result;
    }
    @WebMethod
    public List<CustomerListDto> getCustomerList(@WebParam (name = "start") Integer start, @WebParam(name = "limit")Integer limit) throws validationException {
        if (limit==null||limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start==null||start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        CustomerService customerService = new CustomerService();
        List<CustomerListDto> customerListDtos = customerService.getCustomersList(page);
        return   customerListDtos;

    }

}
