package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.EntityManagerOperationsProxy;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dao.rentalImpl;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.RentalMapper;
import gov.iti.jets.presentation.models.Page;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class RentalService  {
    rentalImpl RENTAL = new rentalImpl();
    private final EntityManagerOperations entityManagerOperations;

    EntityManagerLoaner entityManagerLoaner=new EntityManagerLoaner();
    public RentalService(){
        entityManagerOperations = new EntityManagerOperationsProxy();
    }
    public Rental  insertRental( EntityManager entityManager,Rental rental) throws validationException {

        Rental newRental =entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Rental.class),rental,"create");

        return newRental;
    }
    public List<Rental> getRental(Integer customerId, Integer inventoryId,Integer filmId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        rentalImpl rental = new rentalImpl();
        List<Rental> rentalList =rental.getRentByCustomer(entityManager,customerId,inventoryId);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return rentalList;

    }
    public Rental updateRental(EntityManager entityManager,Rental rental) throws validationException {
        Rental updatedRental = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Rental.class),rental,"update");
        return  updatedRental;
    }
    public List<CustomerRentalDto> getRentalByCustomerId(Integer customerId, Page page) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        rentalImpl rental = new rentalImpl();
        List<Rental> rentalList =rental.getRentalByCustomerId(entityManager,customerId,page);
        List<CustomerRentalDto> rentalDtos = new ArrayList<>();
        for (Rental rentalObj:rentalList) {
            rentalDtos.add(RentalMapper.INSTANCE.rentalToRentalDto(rentalObj));
        }
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return rentalDtos;
    }

}
