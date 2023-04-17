package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public interface filmDao {

    List<Film> getFilmByName(EntityManager entityManager, String filmName, Page page) throws validationException;


    List<FilmList> getFilmLists(EntityManager entityManager, Page page) throws validationException;

    Optional<Boolean> isFilmInStock(EntityManager entityManager, int filmId) throws validationException;



    ///wrong
    Optional<Integer> getFilmRenter(EntityManager entityManager, int inventory) throws validationException;

    Integer getFilmQuantity(EntityManager entityManager, int filmId, int storeId) throws validationException;



    Film getFilmById(EntityManager entityManager, Integer filmId) throws validationException;

    Film createFilm(EntityManager entityManager, Film film) throws validationException;
}
