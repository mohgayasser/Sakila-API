package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dao.rentalImpl;
import gov.iti.jets.persistence.entity.Rental;

import java.util.List;

public class RentalService  {
    rentalImpl RENTAL = new rentalImpl();
    RepositoryImpl<Rental, Integer> repo = new RepositoryImpl<>(Rental.class);
    public Rental  insertRental(Rental rental){
        repo.create(rental);
        return rental;
    }
    public List<Rental> getRental(Integer customerId, Integer inventoryId,Integer filmId){
        rentalImpl rental = new rentalImpl();
        List<Rental> rentalList =rental.getRentByCustomer(customerId,inventoryId);
        return rentalList;

    }
    public Rental updateRental(Rental rental){
        Rental updatedRental = repo.update(rental);
        return  updatedRental;
    }

}
