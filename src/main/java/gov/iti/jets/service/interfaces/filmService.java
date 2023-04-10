package gov.iti.jets.service.interfaces;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dao.filmImpl;
import gov.iti.jets.persistence.entity.Film;

public interface filmService {
    filmImpl film = new filmImpl();
    RepositoryImpl<Film, Integer> repo = new RepositoryImpl<>(Film.class);
}
