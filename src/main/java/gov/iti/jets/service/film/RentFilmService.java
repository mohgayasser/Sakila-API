package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dao.*;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.presentation.models.RentFilmDto;
import gov.iti.jets.service.CustomerService;
import gov.iti.jets.service.paymentService;
import gov.iti.jets.service.RentalService;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class RentFilmService  {
    private final EntityManagerOperations entityManagerOperations;
    filmImpl film = new filmImpl();
    EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();

    public RentFilmService() {
        this.entityManagerOperations = new EntityManagerOperationsProxy();
    }

    public int rentFilm(RentFilmDto rentFilmDto) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        //check customer id
        Customer customer =entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Customer.class),rentFilmDto.getCustomerId(),"find");

        //check staff
        Optional<Staff> staff = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Staff.class),rentFilmDto.getStaffId(),"find"));
        if (staff.isPresent()) {
            //if this staff is try to rent film in his store or another one
            if(staff.get().getStore().getId() == rentFilmDto.getStoreId()) {
                //check if this film is existing in stock
                filmService checkFilm = new filmService();
                boolean isAvailable = checkFilm.isFilmInStockManaged(entityManager,rentFilmDto.getFilmId());

                if (isAvailable) {
                    Integer numberOfCopies = film.getFilmQuantity(entityManager,rentFilmDto.getFilmId(), customer.getStore().getId());

                    if (numberOfCopies < rentFilmDto.getNumberOfCopies()) {
                        throw new validationException("this film " + rentFilmDto.getFilmId() + " does not Available in this Store with needed number of copies");
                    } else {
                        CustomerService customerService = new CustomerService();
                        //get customer balance now
                        BigDecimal customerBalance = customerService.getCustomerBalanceinSpecificDateManaged(entityManager,rentFilmDto.getCustomerId(),new Date());
                        // check if this customer has enough balance to rent this copies of selected film or not
                        if (customerBalance.compareTo(BigDecimal.valueOf(0))==0) {
                            //retrieve the inventories' id that we will take those copies from it
                            InventoryImpl inventoryimpl = new InventoryImpl();
                            List<Inventory> inventory = inventoryimpl.getAllInventories(entityManager,rentFilmDto.getFilmId(), rentFilmDto.getStoreId());
                            AtomicReference<Rental> rental = new AtomicReference<>();
                            RentalService crudRentalService = new RentalService();
                            AtomicReference<Integer> counter = new AtomicReference<>(rentFilmDto.getNumberOfCopies());
                            paymentService paymentService = new paymentService( );
                            inventory.forEach(e -> {
                                AtomicBoolean stillRent = new AtomicBoolean(false);
                                e.getRentals().forEach(rental1 -> {
                                    if (rental1.getReturnDate() == null) {
                                        stillRent.set(true);
                                    }
                                });
                                if ((!stillRent.get()) && counter.get() > 0) {
                                    try{

                                        rental.set(new Rental(new Date(), e, customer, staff.get(), new Date()));
                                        Rental newRental = crudRentalService.insertRental(entityManager,rental.get());

                                        // cost of rent 1 copy of selected film
                                        Payment paymentDto = paymentService.newPayment(entityManager,new Payment(customer, staff.get(), newRental, customerBalance, new Date(), new Date()));
                                        System.out.println("payment new ->"+paymentDto);
                                        counter.getAndSet(counter.get() - 1);
                                    }catch (validationException validationException){
                                        throw new RuntimeException(validationException.getMessage());
                                    }
                                }
                            });
                        }else {
                            throw new validationException(" the customer has an outstanding balance that needs to be paid off before new Rent processing.");
                        }
                    }
                } else {
                    throw new validationException("unfortunately, this film does not Available in all stocks");
                }
            }else {
                throw new validationException("this staff member does not allow to rent this film, he doesn't work in this store.");

            }
        }else {
            throw new validationException("this staff member does not exist in our system.");
        }
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return 1;
    }

}
