package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.filmDao;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.service.util.models.Page;
import jakarta.persistence.Query;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class filmImpl extends RepositoryImpl<Film,Integer> implements filmDao {
    EntityManagerLoaner entityManagerLoaner;
    public filmImpl() {
        super(Film.class);
        entityManagerLoaner = new EntityManagerLoaner();

    }
    @Override
    public List<Film> getFilmByName(String filmName, Page page) {
        String SQLStr ="From Film f where f.title LIKE :name";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("name","%" +filmName+ "%");
        List<Film> filmList =  entityManagerLoaner.executeList(new transactionImpl<>(Film.class),SQLStr,map,page);
        filmList.forEach(filmDto -> System.out.println("in database"+filmDto.getId()));
        return  filmList;
    }

    @Override
    public List<FilmList> getFilmLists(Page page) {
        String SQLStr ="From FilmList fl";
        List<FilmList> filmList = entityManagerLoaner.executeList(new transactionImpl<>(FilmList.class),SQLStr,new HashMap<>(),page);
        return  filmList;
    }

    @Override
    public Optional<Boolean> isFilmInStock(int filmId) {
        String sqlQuery = " from Inventory I where I.film.id= :id ";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",filmId);
        Inventory result = entityManagerLoaner.execute(new transactionImpl<>(Inventory.class),sqlQuery,map);
        Optional<Boolean> exists = null;
        if(result!=null){
            return  Optional.ofNullable(true);
        }else {
           return Optional.ofNullable(false);
        }
    }
  ///wrong
    @Override
    public Optional<Integer> getFilmRenter(int inventory) {
        String sqlQuery = "SELECT inventory_held_by_customer(:id) FROM dual";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",inventory);
        Integer result = entityManagerLoaner.execute(new transactionImpl<>(Integer.class),sqlQuery,map);

        return  Optional.ofNullable(result);
    }

    @Override
    public Integer getFilmQuantity(int filmId, int storeId) {
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


}
