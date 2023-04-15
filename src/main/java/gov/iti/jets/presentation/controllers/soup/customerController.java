package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.CustomerService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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


}
