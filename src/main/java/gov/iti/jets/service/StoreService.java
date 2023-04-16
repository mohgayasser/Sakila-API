package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.entity.Store;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.Optional;

public class StoreService {
    EntityManagerLoaner entityManagerLoaner=new EntityManagerLoaner();

    public Store getStoreById(Integer StoreId) throws validationException {
        Optional<Store> store = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Store.class),StoreId,"find"));
        if(store.isPresent())
            return store.get();
        else {
            throw new validationException("this store Id is wrong.");
        }
    }
}
