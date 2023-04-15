package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dao.InventoryImpl;
import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.presentation.dto.ReturnFilmDto;
import gov.iti.jets.service.RentalService;
import gov.iti.jets.service.interfaces.filmService;
import gov.iti.jets.service.paymentService;
import gov.iti.jets.service.util.exceptions.validationException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ReturnFilmService  implements filmService {
    RepositoryImpl<Customer, Integer> customerRepository = new RepositoryImpl<>(Customer.class);

    public boolean returnFilm(ReturnFilmDto returnFilmDto) throws validationException {
        RentalService rentalService = new RentalService();
        InventoryImpl inventory =new InventoryImpl();
        paymentService paymentService = new paymentService();
        Optional<Film> selectedFilm =film.findById(returnFilmDto.getFilmId());
        if(selectedFilm.isPresent()) {
            //check customer id
            Optional<Customer> customer = customerRepository.findById(returnFilmDto.getCustomerId());
            if (customer.isPresent()) {
                List<Inventory> inventories = inventory.getAllInventories(returnFilmDto.getFilmId(), returnFilmDto.getStoreId());
                AtomicReference<Integer> counter = new AtomicReference<>(returnFilmDto.getNumberOfCopies());
                inventories.forEach(inv -> {
                    inv.getRentals().forEach(rental -> {
                        if (rental.getCustomer().getId() == returnFilmDto.getCustomerId()) {
                            if (rental.getReturnDate() == null && counter.get() > 0) {
                                rental.setReturnDate(new Date());
                                rental.getPayments().forEach(payment -> {
                                    System.out.println("update payment");
                                    payment.setAmount(BigDecimal.valueOf(selectedFilm.get().getRentalRate()));
                                    paymentService.updatePayment(payment);
                                });
                                Rental updatedRental = rentalService.updateRental(rental);
                                counter.getAndSet(counter.get() - 1);
                            }
                        }
                    });
                });
            } else {
                throw new validationException("this customer does not exists in our system");
            }
        }else {
            throw new validationException("this film does not exists in our system");
        }
        return true;
    }
}

