package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.filmImpl;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.dto.films.OperationalFilmDto;
import gov.iti.jets.presentation.mappers.OperationalFilmMapper;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.OperationalToFilmMapper;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class insertFilmService   {
    filmImpl film = new filmImpl();
  EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();

    public boolean insertFilm(gov.iti.jets.presentation.models.OperationalFilmDto filmDto) throws validationException {

        OperationalFilmDto operationalFilmDto =OperationalFilmMapper.INSTANCE.presentationToService(filmDto);
        Film newFilm = OperationalToFilmMapper.INSTANCE.OperationalToFilm(operationalFilmDto);
        Optional<Language> FilmLanguage = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Language.class),operationalFilmDto.getLanguageId(),"find"));
        newFilm.setLanguage(FilmLanguage.get());
        if(FilmLanguage.isPresent()) {
            newFilm.setLanguage(FilmLanguage.get());
            System.out.println("language "+FilmLanguage.get());
        }else {
           throw new validationException("this language id"+operationalFilmDto.getLanguageId()+" does not exists in ouyr system");
        }
        if(operationalFilmDto.getOrignalLanguageId()!=0) {
            Optional<Language> filmOrignalLanguage = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Language.class),operationalFilmDto.getOrignalLanguageId(),"find"));
            newFilm.setOriginalLanguage(filmOrignalLanguage.get());
        }
        newFilm.setLastUpdate(new Date());

        newFilm.setInventories(insertInventoryList(newFilm,operationalFilmDto));


        Film addedFilm = film.createFilm(newFilm);
        if(addedFilm == null) {
            throw new validationException("invalid data please check your data with required then try again");
        }
        fillCategory(operationalFilmDto,addedFilm);
        fillFimActors(operationalFilmDto,addedFilm);
        System.out.println(addedFilm);
        return true;
    }
    private  Set<Inventory> insertInventoryList( Film film,OperationalFilmDto operationalFilmDto){
        Set<Inventory> inventories = new HashSet<>();
        operationalFilmDto.getStoresIds().forEach(store->{
            try {
                Optional<Store> filmStore = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Store.class),store,"find"));
                if(filmStore.isPresent()) {
                    Inventory inventory = new Inventory(film, filmStore.get(), new Date());
                   inventories.add(inventory);
                }
            } catch (validationException e) {
                throw new RuntimeException(e);
            }
        });

        return inventories;
    }
    private void fillFimActors(OperationalFilmDto operationalFilmDto,Film film){
        Set<FilmActor> actors =new HashSet<>();

        operationalFilmDto.getFilmActorsIds().forEach(actor->{
            try {
                Optional<Actor> filmActor = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Actor.class),actor,"find"));
                if(filmActor.isPresent()) {
                    System.out.println(filmActor);
                    FilmActor newFilmActor = new FilmActor(filmActor.get(), film, new Date());
                    FilmActor actor1 = entityManagerLoaner.executeCRUD(new TransactionImpl<>(FilmActor.class),newFilmActor,"update");

                }
            } catch (validationException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void fillCategory(OperationalFilmDto operationalFilmDto,Film film){
        Set<FilmCategory> filmCategories =new HashSet<>();

        operationalFilmDto.getFilmCategoriesIds().forEach(category->{
            try {
                Optional<Category> filmCategory = Optional.ofNullable(entityManagerLoaner.executeCRUD(new TransactionImpl<>(Category.class),category,"find"));
                System.out.println("out from category "+filmCategory.isPresent()+" isempty "+filmCategory.isEmpty());
                if(filmCategory.isPresent()) {
                    FilmCategory categoryObj = new FilmCategory(film,filmCategory.get(), new Date());
                    FilmCategory category1 =entityManagerLoaner.executeCRUD(new TransactionImpl<>(FilmCategory.class),categoryObj,"update");

                }
            } catch (validationException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
