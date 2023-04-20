package gov.iti.jets.presentation.controllers.rest;

import gov.iti.jets.persistence.dto.staff.ShowStaffDto;
import gov.iti.jets.persistence.dto.staff.StaffListDto;
import gov.iti.jets.persistence.dto.staff.StaffPaymentDto;
import gov.iti.jets.persistence.dto.staff.StaffRentalCustomerDto;
import gov.iti.jets.presentation.models.GetStaffByIdDTo;
import gov.iti.jets.presentation.models.InsertStaffDto;
import gov.iti.jets.presentation.models.Link;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.StaffService;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

@Path("staffs")
public class StaffRequests {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffById (@PathParam("id") Integer Id,@Context UriInfo uriInfo) {
        if(Id<1){
            throw new validationException("you need to enter a valid Id which started from 1");
        }else {
            StaffService staff = new StaffService();
            ShowStaffDto getStaff = staff.getStaffById(Id);
            gov.iti.jets.presentation.models.Link link =new Link(uriInfo.getAbsolutePathBuilder().toString(),"self");
            GetStaffByIdDTo getStaffByIdDTo = new GetStaffByIdDTo();
            getStaffByIdDTo.setShowStaffDto(getStaff);
            getStaffByIdDTo.addLink(link,uriInfo);

            return Response.ok(getStaffByIdDTo).build();
        }
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStaffMember (@PathParam("id") Integer Id)  {
        if (Id < 1) {
            throw new validationException("you need to enter a valid Id which started from 1");
        } else{
            StaffService staff = new StaffService();
            boolean result = staff.softDelete(Id);

            return Response.ok(result).build();        }
    }
    @GET
    @Path("{id}/getPayments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffPayments (@PathParam("id") Integer Id)  {
        if (Id < 1) {
            throw new validationException("you need to enter a valid Id which started from 1");
        } else {
            StaffService staff = new StaffService();
            Set<StaffPaymentDto> getStaff = staff.getStaffPaymentsCreate(Id);
            GenericEntity entity = new GenericEntity<Set<StaffPaymentDto>>(getStaff){};

            return Response.ok(entity).build();
        }
    }
    @GET
    @Path("{id}/getRental")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffRentals (@PathParam("id") Integer Id) {
        if (Id < 1) {
            throw new validationException("you need to enter a valid Id which started from 1");
        } else {
            StaffService staff = new StaffService();
            Set<StaffRentalCustomerDto> getStaff = staff.getStaffMemberRentalsAndCustomers(Id);
            GenericEntity entity = new GenericEntity<Set<StaffRentalCustomerDto>>(getStaff){};
            return Response.ok(entity).build();
        }
    }
    @GET
    @Path("getALlStaff")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStaffList(@QueryParam ("start") Integer start, @QueryParam("limit") Integer limit) {
        if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        StaffService staffService =new StaffService();
        List<StaffListDto> staffListDtos=staffService.getStaffList(page);
        GenericEntity entity = new GenericEntity<List<StaffListDto>>(staffListDtos){};
        return Response.ok(entity).build();
    }

    @POST
    @Path("newStaff")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertStaffMember (InsertStaffDto insertStaffDto,@Context UriInfo uriInfo) {

        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<InsertStaffDto>> violations = handler.getValidation().validate(insertStaffDto);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        StaffService staffService= new StaffService();
        Integer result;
        try {
            result = staffService.insertStaffMember(insertStaffDto);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        URL url= null;
        try {
            url = new URL(uriInfo.getAbsolutePath()+"/"+result.toString());
            return Response.created(url.toURI()).build();
        } catch (MalformedURLException | URISyntaxException e) {
            return Response.ok(result).build();
        }
    }

}
