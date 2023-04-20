package gov.iti.jets.presentation.controllers.rest;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.customer.CustomerListDto;
import gov.iti.jets.persistence.dto.customer.CustomerPaymentDto;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.presentation.models.*;
import gov.iti.jets.presentation.models.Link;
import gov.iti.jets.service.CustomerService;
import gov.iti.jets.service.util.validations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@Path("customers")
public class CustomerRequests {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") Integer id,@Context UriInfo uriInfo )  {
        if (id==null||id < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            CustomerService getCustomerService = new CustomerService();
            CustomerDto customerDto = getCustomerService.getCustomerById(id);
            Link link =new Link(uriInfo.getAbsolutePathBuilder().toString(),"self");
            GetCustomerByIdDTo getCustomerByIdDTo = new GetCustomerByIdDTo();
            getCustomerByIdDTo.setCustomerDto(customerDto);
            getCustomerByIdDTo.addLink(link,uriInfo);
            return  Response.ok(getCustomerByIdDTo).build();


        }
    }
    @GET
    @Path("getBalanceInDate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getcustomerBalanceInDate(GetCustomerBalance getCustomerBalance)  {
        String valid = ValidFieldsValidator.validate(getCustomerBalance);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
           Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(getCustomerBalance.getDate().getYear(),getCustomerBalance.getDate().getMonth(),getCustomerBalance.getDate().getDay()).build();
            System.out.println("entered date ->" +cal.getTime());
            CustomerService getCustomerService = new CustomerService();
            BigDecimal amount = getCustomerService.getCustomerBalanceinSpecificDate(getCustomerBalance.getId(), cal.getTime());
            return Response.ok(amount).build();

        }
    }
    @GET
    @Path("{id}/getRentalHistory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerRentalHistory(@PathParam("id") Integer customerId)  {
        if(customerId==null||customerId <0){
            throw new validationException("you need to enter a valid id");

        }
        CustomerService customerService =new CustomerService();
        Set<CustomerRentalDto> rentalDtos =customerService.getCustomerRentalHistory(customerId);
        GenericEntity entity = new GenericEntity<Set<CustomerRentalDto>>(rentalDtos){};

        return  Response.ok(entity).build();
    }

    @GET
    @Path("{id}/getPaymentHistory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerPaymentHistory(@PathParam("id") Integer customerId)  {
        if(customerId==null||customerId <0){
            throw new validationException("you need to enter a valid id");

        }
        CustomerService customerService =new CustomerService();
        Set<CustomerPaymentDto> rentalDtos =customerService.getCustomerPaymentHistory(customerId);
        GenericEntity entity = new GenericEntity<Set<CustomerPaymentDto>>(rentalDtos){};
        return  Response.ok(entity).build();
    }
    @POST
    @Path("newCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  Response newCustomer(AddCustomerDto customerDto,@Context UriInfo uriInfo){
        String valid = ValidFieldsValidator.validate(customerDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        CustomerService customerService = new CustomerService();
        Integer result =customerService.AddCustomer(customerDto);
        URL url= null;
        try {
            url = new URL(uriInfo.getAbsolutePath()+"/"+result.toString());
            return Response.created(url.toURI()).build();
        } catch (MalformedURLException | URISyntaxException e) {
            return Response.ok(result).build();
        }
    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id") Integer customerId)  {
        if(customerId==null||customerId <0){
            throw new validationException("you need to enter a valid id starts from 1");
        }
        CustomerService customerService = new CustomerService();
        boolean result=customerService.softDelete(customerId);
        return Response.ok(result).build();
    }
    @GET
    @Path("getALlCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomerList(@QueryParam ("start") Integer start, @QueryParam("limit") Integer limit) {
        if (limit==null||limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start==null||start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        CustomerService customerService = new CustomerService();
        List<CustomerListDto> customerListDtos = customerService.getCustomersList(page);
        GenericEntity entity = new GenericEntity<List<CustomerListDto>>(customerListDtos){};
        return Response.ok(entity).build();

    }

}
