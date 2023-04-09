package gov.iti.jets.service.film;

import gov.iti.jets.persistence.dao.RepositoryImpl;
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

public class insertFilmService {
    RepositoryImpl<Film, Integer> filmRepo = new RepositoryImpl<>(Film.class);
    RepositoryImpl<Language, Integer> languageRepo = new RepositoryImpl<>(Language.class);
    RepositoryImpl<Actor, Integer> actorRepo = new RepositoryImpl<>(Actor.class);
    RepositoryImpl<Store, Integer> storeRepo = new RepositoryImpl<>(Store.class);
    RepositoryImpl<Inventory, Integer> inventoryRepo = new RepositoryImpl<>(Inventory.class);
    RepositoryImpl<FilmActor, Integer> filmActorRepo = new RepositoryImpl<>(FilmActor.class);

    filmImpl film = new filmImpl();
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
        Film addedFilm = filmRepo.create(newFilm);
        System.out.println("added film is "+addedFilm);
        return true;
    }
    private  boolean insertInventory( Film film,OperationalFilmDto operationalFilmDto){
        operationalFilmDto.getStoresIds().forEach(store->{
            try {
                Optional<Store> filmStore = storeRepo.findById(store);
                if(filmStore.isPresent()) {
                    Inventory inventory = new Inventory(film, filmStore.get(), new Date());
                    Inventory addedInventory = inventoryRepo.create(inventory);
                }
            } catch (validationException e) {
                throw new RuntimeException(e);
            }
        });

        return true;
    }
    private boolean insertStoredata(OperationalFilmDto operationalFilmDto,Film film){
        Set<FilmActor> actors =new HashSet<>();

        operationalFilmDto.getFilmActorsIds().forEach(actor->{
            try {
                Optional<Actor> filmActor = actorRepo.findById(actor);
                if(filmActor.isPresent()) {
                    FilmActor newFilmActor = new FilmActor(filmActor.get(), film, new Date());
                    FilmActor addedFilmActor = filmActorRepo.create(newFilmActor);

                }
            } catch (validationException e) {
                throw new RuntimeException(e);
            }
        });
        return  true;
    }
}
