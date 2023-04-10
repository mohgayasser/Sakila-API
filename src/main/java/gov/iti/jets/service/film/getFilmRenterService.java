package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.service.customer.getCustomerService;
import gov.iti.jets.service.interfaces.filmService;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.Optional;

//get customer id for the customer that rent that film
public class getFilmRenterService implements filmService {

    public CustomerDto FilmRenter(int filmId) throws validationException {
        Optional<Film> searchingFilm = repo.findById(filmId);
        if(searchingFilm.isPresent()) {
            CustomerDto returnedCustomer = null;
            Optional<Integer> customerId = film.getFilmRenter(filmId);
            if (customerId.isPresent()) {

                getCustomerService getCustomerService = new getCustomerService();
                returnedCustomer = getCustomerService.getCustomerById(customerId.get());

            }

            return returnedCustomer;
        }else {
         throw new validationException("this film id ("+filmId+") does not exist in our system");
        }
    }

}
