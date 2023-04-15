package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.films.getFilmListDto;
import gov.iti.jets.presentation.dto.OperationalFilmDto;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.presentation.dto.RentFilmDto;
import gov.iti.jets.presentation.dto.ReturnFilmDto;
import gov.iti.jets.service.film.*;
import gov.iti.jets.service.util.customAnnotations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.models.Page;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

@WebService (targetNamespace = "filmController")
public class filmController {
    @WebMethod
    public  List<getFilmDto> getFilmByName( @WebParam(name = "partOfFilmName") String filmName,@WebParam(name = "start") Integer start ,@WebParam(name="limit") Integer limit) throws validationException {
        if(filmName.equals("")){
            throw new validationException("enter film titer for searching");
        }if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number  must be at least 1");
        }
        Page page = new Page(start-1,limit);
        filmService getFilmsService =new filmService();
        List<getFilmDto> getFilmDtoList =  getFilmsService.getFilmByName(filmName,page);
        return getFilmDtoList;

    }
    @WebMethod
    public getFilmDto getFilmById(@WebParam(name = "filmId")int filmId) throws validationException{
        if(filmId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        filmService getFilmService =new filmService();
        getFilmDto filmDto =getFilmService.getFilmById(filmId);
        return  filmDto;
    }
    @WebMethod
    public List<getFilmListDto> getFilmList(@WebParam(name = "startPage") int start, @WebParam(name = "pageSize")int limit) throws validationException {

        if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        filmService getFilmService = new filmService();
        List<getFilmListDto> getFilmListDto =getFilmService.getFilmsFromFilmListView(page);
        return getFilmListDto;


    }
    @WebMethod()
    public boolean insertFilm(@WebParam(name = "film",mode = WebParam.Mode.IN)OperationalFilmDto filmDto) throws validationException {
        System.out.println(filmDto);
        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<OperationalFilmDto>> violations = handler.getValidation().validate(filmDto);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        insertFilmService insertFilmService = new insertFilmService();
        boolean result = insertFilmService.insertFilm(filmDto);
        return result;
    }
    @WebMethod
    public Boolean checkFilmExistance(@WebParam (name = "FilmId") int id) throws validationException {
        Boolean result = null;
        if(id<0){
            throw new validationException("You need to enter valid id which for ex starting from 1");
        }
        filmService check =new filmService();
        result = check.isFilmInStock(id);
        return result;
    }
    @WebMethod
    public Set<CustomerDto> getFilmRenter(@WebParam (name = "FilmId") int id) throws validationException {
        if(id<0){
            throw new validationException("You need to enter valid id which for ex starting from 1");
        }
        filmService getFilmRenterService =new filmService();
        Set<CustomerDto> customerDto = getFilmRenterService.FilmRenter(id);
        if(customerDto !=null){
            return  customerDto;

        }
        else {
            throw new validationException("this film isn't renting to any customer recently");

        }
    }
    @WebMethod
    public int rentFilm(@WebParam(name = "customerId") int customerId,
                        @WebParam(name = "storeId") int storeId,
                        @WebParam(name = "staffId") int staffId,
                        @WebParam (name = "filmId") int filmId,
                        @WebParam(name = "numberOfCopies")int copies) throws validationException{

        RentFilmDto rentFilmDto = new RentFilmDto(customerId,storeId,staffId,filmId,copies);
        String valid = ValidFieldsValidator.validate(rentFilmDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        RentFilmService rentFilmService = new RentFilmService();
        Integer result = rentFilmService.rentFilm(rentFilmDto);

        return result;
    }
    @WebMethod
    public boolean returnFilm(@WebParam(name = "customerId") int customerId,
                        @WebParam(name = "storeId") int storeId,
                        @WebParam (name = "filmId") int filmId,
                        @WebParam(name = "returnQuantity")int copies) throws validationException{

        ReturnFilmDto returnFilmDto = new ReturnFilmDto(customerId,storeId,filmId,copies);
        String valid = ValidFieldsValidator.validate(returnFilmDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        ReturnFilmService returnFilmService = new ReturnFilmService();
        boolean result = returnFilmService.returnFilm(returnFilmDto);

        return result;
    }
}
