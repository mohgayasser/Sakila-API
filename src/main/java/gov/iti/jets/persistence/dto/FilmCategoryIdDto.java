package gov.iti.jets.persistence.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategoryId} entity
 */
public class FilmCategoryIdDto implements Serializable {
    private final Integer filmId;
    private final Integer categoryId;

    public FilmCategoryIdDto(Integer filmId, Integer categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}