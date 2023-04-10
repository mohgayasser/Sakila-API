package gov.iti.jets.service.film;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.service.interfaces.filmService;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.Optional;

public class checkFilmInInventoryService implements filmService {


    public Boolean isFilmInStock(int FilmId) throws validationException {

        Boolean Quantity =null;
        try {
            Optional<Film> searchingFilm = repo.findById(FilmId);
            if(searchingFilm.isPresent()) {
                Optional<Boolean> filmQuantity = film.isFilmInStock(FilmId);

                if (filmQuantity.isPresent()) {
                    Quantity = filmQuantity.get();
                } else {
                    throw new validationException("this film Id (" + FilmId + ") does not exist in our system");
                }
                return Quantity;
            }else {
                throw new validationException("this film id ("+FilmId+") does not exist in our system");
            }
        }catch (NullPointerException e){
            throw new validationException("this film id ("+FilmId+") does not exist in our system");
        }
    }
}
