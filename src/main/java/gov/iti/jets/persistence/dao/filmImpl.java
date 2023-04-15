package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.filmDao;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.service.util.models.Page;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class filmImpl extends RepositoryImpl<Film,Integer> implements filmDao {
    public filmImpl() {
        super(Film.class);
    }

    @Override
    public List<Film> getFilmByName(String filmName, Page page) {
        Query query = _entityManager.createQuery("From Film f where f.title LIKE :name")
                .setParameter("name", "%" +filmName+ "%" );
        query.setFirstResult(page.getPageNumber()*page.getPageSize());
        query.setMaxResults(page.getPageSize());
        List<Film> filmList = query.getResultList();
        filmList.forEach(filmDto -> System.out.println("in database"+filmDto.getId()));

        return  filmList;
    }

    @Override
    public List<FilmList> getFilmLists(Page page) {
        Query query = _entityManager.createQuery("From FilmList fl");
        query.setFirstResult(page.getPageNumber()*page.getPageSize());
        query.setMaxResults(page.getPageSize());
        List<FilmList> filmList = query.getResultList();
        return  filmList;
    }

    @Override
    public Optional<Boolean> isFilmInStock(int filmId) {
        //String sqlQuery = "SELECT inventory_in_stock(:id) FROM dual";
        String sqlQuery = " from Inventory I where I.film.id= :id  ";
        Query query = _entityManager.createQuery(sqlQuery);
        query.setParameter("id",filmId);
        query.setMaxResults(1);
        Inventory result = (Inventory) query.getSingleResult();
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
        Query query = _entityManager.createNativeQuery(sqlQuery);
        query.setParameter("id",inventory);
        Integer result = (Integer) query.getSingleResult();
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
