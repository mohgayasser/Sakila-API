package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dao.*;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.presentation.models.ReturnFilmDto;
import gov.iti.jets.service.RentalService;
import gov.iti.jets.service.paymentService;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ReturnFilmService   {
    private final EntityManagerOperations entityManagerOperations;

    filmImpl film = new filmImpl();
    EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();

    public ReturnFilmService() {
        this.entityManagerOperations = new EntityManagerOperationsProxy();
    }

    public boolean returnFilm(ReturnFilmDto returnFilmDto) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        RentalService rentalService = new RentalService();
        InventoryImpl inventory =new InventoryImpl();
        paymentService paymentService = new paymentService();
        Optional<Film> selectedFilm = Optional.ofNullable(film.getFilmById(entityManager,returnFilmDto.getFilmId()));
        if(selectedFilm.isPresent()) {
            //check customer id
            Optional<Customer> customer = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Customer.class),returnFilmDto.getCustomerId(),"find"));
            if (customer.isPresent()) {
                List<Inventory> inventories = inventory.getAllInventories(entityManager,returnFilmDto.getFilmId(), returnFilmDto.getStoreId());
                AtomicReference<Integer> counter = new AtomicReference<>(returnFilmDto.getNumberOfCopies());
                inventories.forEach(inv -> {
                    inv.getRentals().forEach(rental -> {
                        if (rental.getCustomer().getId() == returnFilmDto.getCustomerId()) {
                            if (rental.getReturnDate() == null && counter.get() > 0) {
                                rental.setReturnDate(new Date());
                                rental.getPayments().forEach(payment -> {

                                    payment.setAmount(BigDecimal.valueOf(selectedFilm.get().getRentalRate()));
                                    try {
                                        paymentService.updatePayment(entityManager,payment);
                                    } catch (validationException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                                try {
                                    Rental updatedRental = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Rental.class),rental,"update");
                                } catch (validationException e) {
                                    throw new RuntimeException(e);
                                }
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
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return true;
    }
}

