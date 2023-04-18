package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.dto.FilmDto;
import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.dto.actor.ActorDto;
import gov.iti.jets.persistence.dto.actor.ActorFilmDto;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.presentation.models.NewActorDto;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Set;

public interface ActorDao {
    public ActorDto getactorById(EntityManager entityManager,Integer actorId) throws validationException;
    public List<ActorFilmDto>getActorFilms(EntityManager entityManager, Integer actorId) throws validationException;
    public boolean addActor(EntityManager entityManager,Actor newActorDto) throws validationException;
    public boolean updateActor(EntityManager entityManager, Actor actor) throws validationException;
    public Set<ActorCategoryDto> getActorFilmsCategory(EntityManager entityManager, Integer actorId) throws validationException;
    public ActorCategoryDto getmostCategory(EntityManager entityManager,Integer actorId) throws validationException;
}
