package gov.iti.jets.service.film;
import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.InventoryImpl;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.filmImpl;
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

import java.util.*;

public class filmService {
    filmImpl film = new filmImpl();
    EntityManagerLoaner entityManagerLoaner= new EntityManagerLoaner();
    public List<getFilmDto> getFilmByName(String FilmTitle, Page page) throws validationException {

        List<Film> filmList = film.getFilmByName(FilmTitle, page);
        List<getFilmDto> getFilmDtoList = new ArrayList<>();
        filmList.forEach(film1 -> {
            getFilmDtoList.add(FilmMapper.INSTANCE.filmToFilmDto(film1));

        });
        return getFilmDtoList;
    }
    public getFilmDto getFilmById(int filmId) throws validationException{

        getFilmDto filmDto =null;
       try {
           Optional<Film> returnedFilm = Optional.ofNullable(film.getFilmById(filmId));

           if(returnedFilm.isPresent()){
                filmDto = FilmMapper.INSTANCE.filmToFilmDto(returnedFilm.get());
           }else {
               throw new validationException("this film id isn't existing in out system");
           }
           return filmDto;
       }catch (NullPointerException e){
           throw new validationException("this film id isn't existing in out system");
        }

    }
    public List<getFilmListDto> getFilmsFromFilmListView(Page page) throws validationException {
        List<FilmList>filmLists = film.getFilmLists(page);
        List<getFilmListDto> getFilmListDtos = new ArrayList<>();
        filmLists.forEach(film1->{
            getFilmListDtos.add(FilmListMapper.INSTANCE.filmListToFilmListDto(film1));
        });
        return getFilmListDtos;
    }
    public Integer getFilmQuantity(int filmId, int storeId) throws validationException {
        Integer Quantity = film.getFilmQuantity(filmId,storeId);
        return  Quantity;
    }
    public Set<CustomerDto> FilmRenter(int filmId) throws validationException {
        Optional<Film> searchingFilm = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Film.class),filmId,"find"));
        if(searchingFilm.isPresent()) {

            InventoryImpl inventory = new InventoryImpl();
            List<Inventory> inventories = inventory.getInventoryIdByFilmId(filmId);
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
            return returnedCustomer;
        }else {
            throw new validationException("this film id ("+filmId+") does not exist in our system");
        }
    }
    public Boolean isFilmInStock(int FilmId) throws validationException {
        String message ="this film Id (" + FilmId + ") does not exist in our system";
        validationException validationException =new validationException(message);
        Boolean Quantity =null;
        try {
            Optional<Film> searchingFilm = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Film.class),FilmId,"find"));
            if(searchingFilm.isPresent()) {
                Optional<Boolean> filmQuantity = film.isFilmInStock(FilmId);

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
        String message ="this film Id (" + FilmId + ") does not exist in our system";
        validationException validationException =new validationException(message);
        Integer inventoriesList =null;
        try {

            inventoriesList = film.getFilmQuantity(FilmId,storeId);

            if (inventoriesList != null) {
                return inventoriesList;
            } else {
                throw new validationException("this film unforgettably does not exists in this store");
            }

        }catch (NullPointerException e){
            throw validationException;
        }
    }
}
