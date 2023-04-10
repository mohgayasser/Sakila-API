package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.ActorDto;
import gov.iti.jets.persistence.dto.FilmActorDto;
import gov.iti.jets.persistence.dto.FilmActorIdDto;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.entity.FilmActor;

import gov.iti.jets.persistence.entity.FilmActorId;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmActorMapper {
    FilmActorMapper INSTANCE = Mappers.getMapper(FilmActorMapper.class);

    FilmActor filmActorDtoToFilmActor(FilmActorDto filmActorDto);

    FilmActorDto filmActorToFilmActorDto(FilmActor filmActor);


    Actor actorDtoToActor(ActorDto actorDto);

    ActorDto actorToActorDto(Actor actor);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    FilmActorId filmActorIdDtoToFilmActorId(FilmActorIdDto filmActorIdDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    FilmActorIdDto filmActorIdToFilmActorIdDto(FilmActorId filmActorId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    FilmActorId updateFilmActorIdFromFilmActorIdDto(FilmActorIdDto filmActorIdDto, @MappingTarget FilmActorId filmActorId);
}
