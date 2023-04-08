package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.dto.films.FilmDto;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategory} entity
 */

public class FilmCategoryDto implements Serializable {
    private final FilmCategoryIdDto id;
    private final FilmDto film;
    private final CategoryDto category;
    private final Date lastUpdate;

    public FilmCategoryDto(FilmCategoryIdDto id, FilmDto film, CategoryDto category, Date lastUpdate) {
        this.id = id;
        this.film = film;
        this.category = category;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategoryIdDto getId() {
        return id;
    }

    public FilmDto getFilm() {
        return film;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}