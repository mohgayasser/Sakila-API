package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.util.models.Page;

import java.util.List;

public interface filmDao {
    public List<Film> getFilmByName(String filmName, Page page);

}
