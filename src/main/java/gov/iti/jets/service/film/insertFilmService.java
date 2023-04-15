package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.dto.films.OperationalFilmDto;
import gov.iti.jets.presentation.mappers.OperationalFilmMapper;
import gov.iti.jets.service.interfaces.filmService;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.OperationalToFilmMapper;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class insertFilmService  implements filmService {

    RepositoryImpl<Language, Integer> languageRepo = new RepositoryImpl<>(Language.class);
    RepositoryImpl<Actor, Integer> actorRepo = new RepositoryImpl<>(Actor.class);
    RepositoryImpl<Store, Integer> storeRepo = new RepositoryImpl<>(Store.class);
    RepositoryImpl<Category, Integer> categoryRepo = new RepositoryImpl<>(Category.class);
    RepositoryImpl<FilmActor, Integer> FilmActorRepo = new RepositoryImpl<>(FilmActor.class);
    RepositoryImpl<FilmCategory, Integer> FilmCategoryRepo = new RepositoryImpl<>(FilmCategory.class);

    public boolean insertFilm(gov.iti.jets.presentation.dto.OperationalFilmDto filmDto) throws validationException {

        OperationalFilmDto operationalFilmDto =OperationalFilmMapper.INSTANCE.presentationToService(filmDto);
        Film newFilm = OperationalToFilmMapper.INSTANCE.OperationalToFilm(operationalFilmDto);
        Optional<Language> FilmLanguage = languageRepo.findById(operationalFilmDto.getLanguageId());
        newFilm.setLanguage(FilmLanguage.get());
        if(FilmLanguage.isPresent()) {
            newFilm.setLanguage(FilmLanguage.get());
            System.out.println("language "+FilmLanguage.get());
        }else {
           throw new validationException("this language id"+operationalFilmDto.getLanguageId()+" does not exists in ouyr system");
        }
        if(operationalFilmDto.getOrignalLanguageId()!=0) {
            Optional<Language> filmOrignalLanguage = languageRepo.findById(operationalFilmDto.getOrignalLanguageId());
            newFilm.setOriginalLanguage(filmOrignalLanguage.get());
        }
        newFilm.setLastUpdate(new Date());

        newFilm.setInventories(insertInventoryList(newFilm,operationalFilmDto));


        Film addedFilm = film.create(newFilm);
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
                Optional<Store> filmStore = storeRepo.findById(store);
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
                Optional<Actor> filmActor = actorRepo.findById(actor);
                if(filmActor.isPresent()) {
                    System.out.println(filmActor);
                    FilmActor newFilmActor = new FilmActor(filmActor.get(), film, new Date());
                    FilmActor actor1 = FilmActorRepo.update(newFilmActor);

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
                Optional<Category> filmCategory = categoryRepo.findById(category);
                System.out.println("out from category "+filmCategory.isPresent()+" isempty "+filmCategory.isEmpty());
                if(filmCategory.isPresent()) {
                    FilmCategory categoryObj = new FilmCategory(film,filmCategory.get(), new Date());
                    FilmCategory category1 =FilmCategoryRepo.update(categoryObj);

                }
            } catch (validationException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
