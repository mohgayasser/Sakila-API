package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.presentation.dto.OperationalFilmDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.models.Page;

import java.util.List;

public interface filmDao {
    public List<Film> getFilmByName(String filmName, Page page);
    public List<FilmList> getFilmLists (Page page);


}
