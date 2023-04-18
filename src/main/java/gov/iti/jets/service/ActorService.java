package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.ActorImpl;
import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.EntityManagerOperationsProxy;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.dto.actor.ActorDto;
import gov.iti.jets.persistence.dto.actor.ActorFilmDto;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.presentation.models.UpdateActorDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.ActorMapper;
import gov.iti.jets.service.util.mapper.UpdateActorMapper;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ActorService {
    private final EntityManagerOperations entityManagerOperations;
    EntityManagerLoaner entityManagerLoaner = new EntityManagerLoaner();

    public ActorService() {
        entityManagerOperations = new EntityManagerOperationsProxy();

    }

    public ActorDto getActorById(Integer actorId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        ActorImpl actor = new ActorImpl();
        ActorDto actorDto = actor.getactorById(entityManager, actorId);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return actorDto;
    }

    public List<ActorFilmDto> getActorFilms(Integer actorId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        ActorImpl actor = new ActorImpl();
        List<ActorFilmDto> filmDtos = actor.getActorFilms(entityManager, actorId);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return filmDtos;
    }

    public boolean addActor(ActorDto newActor) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        ActorImpl actor = new ActorImpl();
        Actor addActor = ActorMapper.INSTANCE.actorDtoToActor(newActor);
        addActor.setLastUpdate(new Date());
        boolean result = actor.addActor(entityManager, addActor);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return result;
    }

    public boolean updateActor(UpdateActorDto actor) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        ActorImpl actorImpl = new ActorImpl();
        Actor updateActor = UpdateActorMapper.INSTANCE.updateActorDtoToActor(actor);
        try {
            actorImpl.getactorById(entityManager, actor.getId());
        }catch (validationException validationException){
          throw new validationException("your entered Actor ID is probably wrong ");
        }
        updateActor.setLastUpdate(new Date());
        boolean result = actorImpl.updateActor(entityManager, updateActor);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return result;
    }

    public Set<ActorCategoryDto> getActorFilmsCategory(Integer actorId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        ActorImpl actor = new ActorImpl();
        Set<ActorCategoryDto> actorCategoryDtos = actor.getActorFilmsCategory(entityManager, actorId);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return actorCategoryDtos;
    }
    public ActorCategoryDto getActorFavCategory(Integer actorId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        ActorImpl actor = new ActorImpl();
        System.out.println("in actor service ->"+actorId);
        ActorCategoryDto actorCategoryDtos = actor.getmostCategory(entityManager, actorId);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return actorCategoryDtos;
    }
}
