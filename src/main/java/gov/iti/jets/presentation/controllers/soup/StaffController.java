package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.staff.ShowStaffDto;
import gov.iti.jets.persistence.dto.staff.StaffListDto;
import gov.iti.jets.persistence.dto.staff.StaffPaymentDto;
import gov.iti.jets.persistence.dto.staff.StaffRentalCustomerDto;
import gov.iti.jets.persistence.views.StaffList;
import gov.iti.jets.presentation.models.InsertStaffDto;
import gov.iti.jets.presentation.models.OperationalFilmDto;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.StaffService;
import gov.iti.jets.service.util.customAnnotations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ConstraintViolation;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

@WebService(targetNamespace = "StaffWebServer")
public class StaffController {
    @WebMethod
    public ShowStaffDto getStaffById (@WebParam(name = "staffId") Integer Id) throws validationException {
        if(Id<1){
            throw new validationException("you need to enter a valid Id which started from 1");
        }else {
        StaffService staff = new StaffService();
        ShowStaffDto getStaff = staff.getStaffById(Id);

         return getStaff;
        }
    }
    @WebMethod
    public boolean deleteStaffMember (@WebParam(name = "staffId") Integer Id) throws validationException {
        if (Id < 1) {
            throw new validationException("you need to enter a valid Id which started from 1");
        } else{
            StaffService staff = new StaffService();
        boolean result = staff.softDelete(Id);

        return result;
    }
    }
    @WebMethod
    public Set<StaffPaymentDto> getStaffPayments (@WebParam(name = "staffId") Integer Id) throws validationException {
        if (Id < 1) {
            throw new validationException("you need to enter a valid Id which started from 1");
        } else {
            StaffService staff = new StaffService();
            Set<StaffPaymentDto> getStaff = staff.getStaffPaymentsCreate(Id);

            return getStaff;
        }
    }
    @WebMethod
    public Set<StaffRentalCustomerDto> getStaffRentals (@WebParam(name = "staffId") Integer Id) throws validationException {
        if (Id < 1) {
            throw new validationException("you need to enter a valid Id which started from 1");
        } else {
            StaffService staff = new StaffService();
            Set<StaffRentalCustomerDto> getStaff = staff.getStaffMemberRentalsAndCustomers(Id);

            return getStaff;
        }
    }
    @WebMethod
    public List<StaffListDto> getStaffList(@WebParam (name = "start") int start, @WebParam(name = "limit")int limit) throws validationException {
        if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        StaffService staffService =new StaffService();
        List<StaffListDto> staffListDtos=staffService.getStaffList(page);
        return  staffListDtos;
    }
    @WebMethod
    public boolean inserStaffMember (@WebParam (name = "staff")InsertStaffDto insertStaffDto) throws validationException, NoSuchAlgorithmException {
        String valid = ValidFieldsValidator.validate(insertStaffDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<InsertStaffDto>> violations = handler.getValidation().validate(insertStaffDto);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        StaffService staffService= new StaffService();
        Integer result =staffService.insertStaffMember(insertStaffDto);
        return true;
    }
}
