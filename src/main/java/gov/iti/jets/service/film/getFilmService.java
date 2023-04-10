package gov.iti.jets.service.film;
import gov.iti.jets.persistence.dto.films.FilmListDto;
import  gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.service.interfaces.filmService;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.FilmListMapper;
import gov.iti.jets.service.util.mapper.FilmMapper;
import gov.iti.jets.service.util.models.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class getFilmService implements filmService {

    public List<getFilmDto> getFilmByName(String FilmTitle, Page page) {


        List<Film> filmList = film.getFilmByName(FilmTitle, page);

        List<getFilmDto> getFilmDtoList = new ArrayList<>();
        filmList.forEach(film1 -> {
            getFilmDtoList.add(FilmMapper.INSTANCE.filmToFilmDto(film1));

        });
        return getFilmDtoList;
    }
    public getFilmDto getFilmById(int filmId) throws validationException{

        getFilmDto filmDto =null;
       try {
           Optional<Film> film = repo.findById(filmId);

           if(film.isPresent()){
                filmDto = FilmMapper.INSTANCE.filmToFilmDto(film.get());
           }else {
               throw new validationException("this film id isn't existing in out system");
           }
           return filmDto;
       }catch (NullPointerException e){
           throw new validationException("this film id isn't existing in out system");
        }

    }
    public List<FilmListDto> getFilmsFromFilmListView(Page page){
        List<FilmList>filmLists = film.getFilmLists(page);
        List<FilmListDto>filmListDtos = new ArrayList<>();
        filmLists.forEach(film1->{
            filmListDtos.add(FilmListMapper.INSTANCE.filmListToFilmListDto(film1));
        });
        return filmListDtos;
    }
}
