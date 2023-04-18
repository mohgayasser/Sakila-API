package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.FilmDto;
import gov.iti.jets.persistence.dto.actor.ActorFilmDto;
import gov.iti.jets.persistence.entity.Film;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorFilmMapper {
    ActorFilmMapper INSTANCE = Mappers.getMapper(ActorFilmMapper.class);

    Film filmDtoToFilm(ActorFilmDto filmDto);

    ActorFilmDto filmToFilmDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film updateFilmFromFilmDto(FilmDto filmDto, @MappingTarget Film film);
}
