package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.films.FilmListDto;
import gov.iti.jets.presentation.dto.OperationalFilmDto;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.service.film.*;
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
        getFilmService getFilmsService =new getFilmService();
        List<getFilmDto> getFilmDtoList =  getFilmsService.getFilmByName(filmName,page);
        return getFilmDtoList;

    }
    @WebMethod
    public getFilmDto getFilmById(@WebParam(name = "filmId")int filmId) throws validationException{
        if(filmId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        getFilmService getFilmService =new getFilmService();
        getFilmDto filmDto =getFilmService.getFilmById(filmId);
        return  filmDto;
    }
    @WebMethod
    public List<FilmListDto> getFilmList(@WebParam(name = "startPage") int start,@WebParam(name = "pageSize")int limit) throws validationException {

        if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        getFilmService getFilmService = new getFilmService();
        List<FilmListDto> filmListDto =getFilmService.getFilmsFromFilmListView(page);
        return filmListDto;


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
}
