package gov.iti.jets.service.film;
import gov.iti.jets.persistence.dao.filmImpl;
import  gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.dto.films.FilmDto;
import gov.iti.jets.util.mapper.films.FilmMapper;
import gov.iti.jets.util.models.Page;

import java.util.ArrayList;
import java.util.List;

public class getFilmService {
    public List<FilmDto> getFilmByName(String FilmTitle, Page page) {
        filmImpl film = new filmImpl();
        List<Film> filmList = film.getFilmByName(FilmTitle, page);

        List<FilmDto> filmDtoList = new ArrayList<>();
        filmList.forEach(film1 -> {
            filmDtoList.add(FilmMapper.INSTANCE.filmToFilmDto(film1));

        });
        return filmDtoList;
    }
}
