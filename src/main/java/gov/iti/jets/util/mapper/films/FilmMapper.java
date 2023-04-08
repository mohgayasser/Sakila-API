package gov.iti.jets.util.mapper.films;

import gov.iti.jets.persistence.dto.films.FilmDto;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.util.mapper.InventoryMapper;
import gov.iti.jets.util.mapper.categories.CategoryMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = InventoryMapper.class)
public interface FilmMapper {
    Film filmDtoToFilm(FilmDto filmDto);

    FilmDto filmToFilmDto(Film film);

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @AfterMapping
    default void linkInventories(@MappingTarget Film film) {
        film.getInventories().forEach(inventory -> inventory.setFilm(film));
    }

    @AfterMapping
    default void linkFilmActors(@MappingTarget Film film) {
        film.getFilmActors().forEach(filmActor -> filmActor.setFilm(film));
    }
}
