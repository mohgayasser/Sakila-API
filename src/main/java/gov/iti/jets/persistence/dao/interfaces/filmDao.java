package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.service.util.models.Page;

import java.util.List;
import java.util.Optional;

public interface filmDao {
    public List<Film> getFilmByName(String filmName, Page page);
    public List<FilmList> getFilmLists (Page page);
    public Optional<Boolean> isFilmInStock(int filmId);
    public  Optional<Integer> getFilmRenter(int filmId);
    Integer getFilmQuantity(int filmId, int storeId);
}
