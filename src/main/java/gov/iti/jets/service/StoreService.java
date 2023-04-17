package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.EntityManagerOperationsProxy;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.entity.Store;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class StoreService {
    EntityManagerLoaner entityManagerLoaner=new EntityManagerLoaner();
    private final EntityManagerOperations entityManagerOperations;
    public  StoreService(){
        entityManagerOperations= new EntityManagerOperationsProxy();
    }
    public Store getStoreById(Integer StoreId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Optional<Store> store = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Store.class), StoreId, "find"));
        if (store.isPresent()){
            entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return store.get();
        }
        else {
            throw new validationException("this store Id is wrong.");
        }
    }
}
