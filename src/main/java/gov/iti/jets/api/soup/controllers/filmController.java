package gov.iti.jets.api.soup.controllers;

import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.dto.films.FilmDto;
import gov.iti.jets.service.film.getFilmService;
import gov.iti.jets.util.exceptions.validationException;
import gov.iti.jets.util.models.Page;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class filmController {
    @WebMethod
    public  List<FilmDto> getFilmByName(String filmName,int start ,int limit)  {

        Page page = new Page(start,limit);
        getFilmService getFilmsService =new getFilmService();
        List<FilmDto> filmDtoList =  getFilmsService.getFilmByName(filmName,page);
        return filmDtoList;

    }
}
