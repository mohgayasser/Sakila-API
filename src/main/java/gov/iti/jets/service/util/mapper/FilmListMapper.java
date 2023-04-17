package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.films.getFilmListDto;
import gov.iti.jets.persistence.views.FilmList;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmListMapper {
    FilmListMapper INSTANCE = Mappers.getMapper(FilmListMapper.class);

    FilmList filmListDtoToFilmList(getFilmListDto getFilmListDto);

    getFilmListDto filmListToFilmListDto(FilmList filmList);

}
