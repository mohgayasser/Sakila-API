package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.List;
import java.util.Optional;

public interface filmDao {
    public List<Film> getFilmByName(String filmName, Page page) throws validationException;
    public List<FilmList> getFilmLists (Page page) throws validationException;
    public Optional<Boolean> isFilmInStock(int filmId) throws validationException;
    public  Optional<Integer> getFilmRenter(int filmId) throws validationException;
    public Integer getFilmQuantity(int filmId, int storeId) throws validationException;
    public Film  getFilmById(Integer filmId) throws validationException;

    Film createFilm(Film film) throws validationException;
}
