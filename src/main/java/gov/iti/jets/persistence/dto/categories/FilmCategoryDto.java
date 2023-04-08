package gov.iti.jets.persistence.dto.categories;

import gov.iti.jets.persistence.dto.inventory.FilmDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategory} entity
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmCategoryDto implements Serializable {
    private  FilmCategoryIdDto id;
    private  FilmDto film;
    private  Date lastUpdate;

    public FilmCategoryDto() {
    }

    public FilmCategoryIdDto getId() {
        return id;
    }

    public void setId(FilmCategoryIdDto id) {
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