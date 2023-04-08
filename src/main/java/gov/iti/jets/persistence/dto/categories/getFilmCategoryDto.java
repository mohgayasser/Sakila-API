package gov.iti.jets.persistence.dto.categories;

import gov.iti.jets.persistence.dto.inventory.FilmDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategory} entity
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class getFilmCategoryDto implements Serializable {
    private getFilmCategoryIdDto id;
    private  FilmDto film;
    private  Date lastUpdate;

    public getFilmCategoryDto() {
    }

    public getFilmCategoryIdDto getId() {
        return id;
    }

    public void setId(getFilmCategoryIdDto id) {
        this.id = id;
    }

    public FilmDto getFilm() {
        return film;
    }

    public void setFilm(FilmDto film) {
        this.film = film;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}