package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.filmDao;
import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.presentation.dto.OperationalFilmDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.models.Page;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public class filmImpl extends RepositoryImpl<Film,Integer> implements filmDao {
    public filmImpl() {
        super(Film.class);
    }

    @Override
    public List<Film> getFilmByName(String filmName, Page page) {
        Query query = _entityManager.createQuery("From Film f where f.title LIKE :name")
                .setParameter("name", "%" +filmName+ "%" );
        query.setFirstResult(page.getPageNumber()*page.getPageSize());
        query.setMaxResults(page.getPageSize());
        List<Film> filmList = query.getResultList();
        filmList.forEach(filmDto -> System.out.println("in database"+filmDto.getId()));

        return  filmList;
    }

    @Override
    public List<FilmList> getFilmLists(Page page) {
        Query query = _entityManager.createQuery("From FilmList fl");
        query.setFirstResult(page.getPageNumber()*page.getPageSize());
        query.setMaxResults(page.getPageSize());
        List<FilmList> filmList = query.getResultList();
        return  filmList;
    }

    @Override
    public Optional<Boolean> isFilmInStock(int filmId) {
        String sqlQuery = "SELECT inventory_in_stock(:id) FROM dual";
        Query query = _entityManager.createNativeQuery(sqlQuery);
        query.setParameter("id",filmId);
        Boolean result = (Boolean) query.getSingleResult();

        return  Optional.ofNullable(result);
    }

    @Override
    public Optional<Integer> getFilmRenter(int filmId) {
        String sqlQuery = "SELECT inventory_held_by_customer(:id) FROM dual";
        Query query = _entityManager.createNativeQuery(sqlQuery);
        query.setParameter("id",filmId);
        Integer result = (Integer) query.getSingleResult();
        return  Optional.ofNullable(result);
    }


}
