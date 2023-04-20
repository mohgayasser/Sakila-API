package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.ActorDao;
import gov.iti.jets.persistence.dto.FilmDto;
import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.dto.actor.ActorDto;
import gov.iti.jets.persistence.dto.actor.ActorFilmDto;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.presentation.models.ActorFavCategory;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.ActorCategoryMapper;
import gov.iti.jets.service.util.mapper.ActorFilmMapper;
import gov.iti.jets.service.util.mapper.ActorMapper;
import jakarta.persistence.EntityManager;

import java.util.*;

public class ActorImpl implements ActorDao {
    EntityManagerLoaner entityManagerLoaner;
    public ActorImpl (){
        entityManagerLoaner = new EntityManagerLoaner();
    }
    @Override
    public ActorDto getactorById(EntityManager entityManager, Integer actorId) throws validationException {
        Actor actor  = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Actor.class),actorId,"find");
        ActorDto actorDto = ActorMapper.INSTANCE.actorToActorDto(actor);
        return actorDto;
    }

    @Override
    public List<ActorFilmDto> getActorFilms(EntityManager entityManager, Integer actorId) throws validationException {
        Actor actor = entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Actor.class), actorId, "find");
        List<ActorFilmDto> filmDtos= new ArrayList<>();
        actor.getFilmActors().forEach(filmActor -> {
            Film film=filmActor.getFilm();
            filmDtos.add(ActorFilmMapper.INSTANCE.filmToFilmDto(film));
        });
        return  filmDtos;
    }

    @Override
    public Integer addActor(EntityManager entityManager, Actor newActor) throws validationException {

        Actor actor  = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Actor.class),newActor,"create");
        return actor.getId();
    }

    @Override
    public boolean updateActor(EntityManager entityManager, Actor actor) throws validationException {
        Actor newActor  = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Actor.class),actor,"update");
        return true;
    }

    @Override
    public Set<ActorCategoryDto> getActorFilmsCategory(EntityManager entityManager, Integer actorId) throws validationException {
        String sqlQuery = "SELECT fc.category FROM FilmCategory fc ,FilmActor fa where fa.actor.id = :id group by fc.category.id";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",actorId);
        List<Category> result = entityManagerLoaner.executeList(entityManager,new TransactionImpl<>(Category.class),sqlQuery,map,null);

        Set<ActorCategoryDto>  actorCategoryDtos =new HashSet<>();
        result.forEach(category -> {
            System.out.println("category ->"+category);
            actorCategoryDtos.add(ActorCategoryMapper.INSTANCE.categoryToActorCategoryDto(category));
        });


        return actorCategoryDtos;
    }

    @Override
    public ActorCategoryDto getmostCategory(EntityManager entityManager, Integer actorId) throws validationException {
        String sqlQuery = "SELECT new gov.iti.jets.presentation.models.ActorFavCategory( Max(sub.count), sub.cat ) from ( select Count(fc.category) as count ,fc.category as cat FROM FilmCategory fc ,FilmActor fa where fa.actor.id = :id group by fc.category.id) as sub";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",actorId);
        ActorFavCategory result = entityManagerLoaner.execute(entityManager,new TransactionImpl<>(ActorFavCategory.class),sqlQuery,map);
        ActorCategoryDto actorCategoryDto = ActorCategoryMapper.INSTANCE.categoryToActorCategoryDto(result.getCategory());
        return actorCategoryDto;
    }
}
