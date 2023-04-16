package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.filmDao;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class filmImpl implements filmDao {
    EntityManagerLoaner entityManagerLoaner;
    public filmImpl() {
        entityManagerLoaner = new EntityManagerLoaner();
    }
    @Override
    public List<Film> getFilmByName(String filmName, Page page) throws validationException {
        String SQLStr ="From Film f where f.title LIKE :name";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("name","%" +filmName+ "%");
        List<Film> filmList =  entityManagerLoaner.executeList(new TransactionImpl<>(Film.class),SQLStr,map,page);
        filmList.forEach(filmDto -> System.out.println("in database"+filmDto.getId()));
        return  filmList;
    }

    @Override
    public List<FilmList> getFilmLists(Page page) throws validationException {
        String SQLStr ="From FilmList fl";
        List<FilmList> filmList = entityManagerLoaner.executeList(new TransactionImpl<>(FilmList.class),SQLStr,new HashMap<>(),page);
        return  filmList;
    }

    @Override
    public Optional<Boolean> isFilmInStock(int filmId) throws validationException {
        String sqlQuery = " from Inventory I where I.film.id= :id ";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",filmId);
        Inventory result = entityManagerLoaner.execute(new TransactionImpl<>(Inventory.class),sqlQuery,map);
        Optional<Boolean> exists = null;
        if(result!=null){
            return  Optional.ofNullable(true);
        }else {
           return Optional.ofNullable(false);
        }
    }
  ///wrong
    @Override
    public Optional<Integer> getFilmRenter(int inventory) throws validationException {
        String sqlQuery = "SELECT inventory_held_by_customer(:id) FROM dual";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",inventory);
        Integer result = entityManagerLoaner.execute(new TransactionImpl<>(Integer.class),sqlQuery,map);

        return  Optional.ofNullable(result);
    }

    @Override
    public Integer getFilmQuantity(int filmId, int storeId) throws validationException {
       InventoryImpl inventoryImp = new InventoryImpl();
       List<Inventory> inventory = inventoryImp.getAllInventories(filmId,storeId);
       AtomicInteger count = new AtomicInteger();

       inventory.forEach(e->{
           AtomicBoolean stillRent = new AtomicBoolean(false);
           e.getRentals().forEach(rental -> {
             if( rental.getReturnDate() == null){
                 stillRent.set(true);
             }
           });
           if(!stillRent.get()){
               count.getAndIncrement();
           }
       });
        return count.get();
    }

    @Override
    public Film getFilmById(Integer filmId) throws validationException {
        Film film = entityManagerLoaner.executeCRUD(new TransactionImpl<>(Film.class),filmId,"find");
        return film;
    }
    @Override
    public Film createFilm(Film film) throws validationException {
        Film addedFilm = (Film) entityManagerLoaner.executeCRUD(new TransactionImpl<>(Film.class),film,"create");
        return addedFilm;
    }
}
