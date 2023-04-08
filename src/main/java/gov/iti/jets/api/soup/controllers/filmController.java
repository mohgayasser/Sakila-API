package gov.iti.jets.api.soup.controllers;

import gov.iti.jets.persistence.dto.films.FilmListDto;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.service.film.getFilmService;
import gov.iti.jets.util.exceptions.validationException;
import gov.iti.jets.util.models.Page;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
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
}
