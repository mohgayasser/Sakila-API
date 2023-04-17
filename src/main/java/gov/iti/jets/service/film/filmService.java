package gov.iti.jets.service.film;
import gov.iti.jets.persistence.dao.*;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.films.getFilmListDto;
import  gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CustomerMapper;
import gov.iti.jets.service.util.mapper.FilmListMapper;
import gov.iti.jets.service.util.mapper.FilmMapper;
import gov.iti.jets.presentation.models.Page;
import jakarta.persistence.EntityManager;

import java.util.*;

public class filmService {
    filmImpl film = new filmImpl();
    EntityManagerLoaner entityManagerLoaner= new EntityManagerLoaner();
    private final EntityManagerOperations entityManagerOperations;

    public filmService() {
        this.entityManagerOperations = new EntityManagerOperationsProxy();
    }

    public List<getFilmDto> getFilmByName(String FilmTitle, Page page) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        List<Film> filmList = film.getFilmByName(entityManager,FilmTitle, page);
        List<getFilmDto> getFilmDtoList = new ArrayList<>();
        filmList.forEach(film1 -> {
            getFilmDtoList.add(FilmMapper.INSTANCE.filmToFilmDto(film1));

        });
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return getFilmDtoList;
    }
    public getFilmDto getFilmById(int filmId) throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        getFilmDto filmDto =null;
       try {
           Optional<Film> returnedFilm = Optional.ofNullable(film.getFilmById(entityManager,filmId));

           if(returnedFilm.isPresent()){
                filmDto = FilmMapper.INSTANCE.filmToFilmDto(returnedFilm.get());
           }else {
               throw new validationException("this film id isn't existing in out system");
           }
           entityManager.flush();
           entityManagerOperations.closeEntityManager();
           return filmDto;
       }catch (NullPointerException e){
           entityManager.flush();
           entityManagerOperations.closeEntityManager();
           throw new validationException("this film id isn't existing in out system");
        }

    }
    public List<getFilmListDto> getFilmsFromFilmListView(Page page) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        List<FilmList>filmLists = film.getFilmLists(entityManager,page);
        List<getFilmListDto> getFilmListDtos = new ArrayList<>();
        filmLists.forEach(film1->{
            getFilmListDtos.add(FilmListMapper.INSTANCE.filmListToFilmListDto(film1));
        });
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return getFilmListDtos;
    }
    public Integer getFilmQuantity(int filmId, int storeId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Integer Quantity = film.getFilmQuantity(entityManager,filmId,storeId);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return  Quantity;
    }
    public Set<CustomerDto> FilmRenter(int filmId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Optional<Film> searchingFilm = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Film.class),filmId,"find"));
        if(searchingFilm.isPresent()) {

            InventoryImpl inventory = new InventoryImpl();
            List<Inventory> inventories = inventory.getInventoryIdByFilmId(entityManager,filmId);
            Set<CustomerDto> returnedCustomer = new HashSet<>();
            inventories.forEach(inventory1 -> {
                inventory1.getRentals().forEach(rental -> {
                    if(rental.getReturnDate() ==null ){
                        CustomerDto customerDto = CustomerMapper.INSTANCE.customerToCustomerDto(rental.getCustomer());
                        returnedCustomer.add(customerDto);
                    }
                });
            });
            if(returnedCustomer.size()<1){
                throw new validationException("this film doesn't rent by any customer recently.");
            }
            entityManager.flush();
            entityManagerOperations.closeEntityManager();
            return returnedCustomer;
        }else {
            entityManager.flush();
            entityManagerOperations.closeEntityManager();
            throw new validationException("this film id ("+filmId+") does not exist in our system");
        }
    }
    public Boolean isFilmInStock(int FilmId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        String message ="this film Id (" + FilmId + ") does not exist in our system";
        validationException validationException =new validationException(message);
        Boolean Quantity =null;
        try {
            Optional<Film> searchingFilm = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Film.class),FilmId,"find"));
            if(searchingFilm.isPresent()) {
                Optional<Boolean> filmQuantity = film.isFilmInStock(entityManager,FilmId);

                if (filmQuantity.isPresent()) {
                    Quantity = filmQuantity.get();
                } else {
                    throw validationException;
                }
                entityManager.flush();
                entityManagerOperations.closeEntityManager();
                return Quantity;
            }else {
                entityManager.flush();
                entityManagerOperations.closeEntityManager();
                throw validationException;
            }
        }catch (NullPointerException e){
            entityManager.flush();
            entityManagerOperations.closeEntityManager();
            throw validationException;
        }
    }
    public Boolean isFilmInStockManaged(EntityManager entityManager,int FilmId) throws validationException {
        String message ="this film Id (" + FilmId + ") does not exist in our system";
        validationException validationException =new validationException(message);
        Boolean Quantity =null;
        try {
            Optional<Film> searchingFilm = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Film.class),FilmId,"find"));
            if(searchingFilm.isPresent()) {
                Optional<Boolean> filmQuantity = film.isFilmInStock(entityManager,FilmId);

                if (filmQuantity.isPresent()) {
                    Quantity = filmQuantity.get();
                } else {
                    throw validationException;
                }

                return Quantity;
            }else {

                throw validationException;
            }
        }catch (NullPointerException e){

            throw validationException;
        }
    }

    public Integer isFilmInInventory(int FilmId,int storeId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        String message ="this film Id (" + FilmId + ") does not exist in our system";
        validationException validationException =new validationException(message);
        Integer inventoriesList =null;
        try {

            inventoriesList = film.getFilmQuantity(entityManager,FilmId,storeId);

            if (inventoriesList != null) {
                entityManager.flush();
                entityManagerOperations.closeEntityManager();
                return inventoriesList;
            } else {
                throw new validationException("this film unforgettably does not exists in this store");
            }

        }catch (NullPointerException e){
            throw validationException;
        }
    }
}
