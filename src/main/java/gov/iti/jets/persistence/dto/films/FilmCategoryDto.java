package gov.iti.jets.persistence.dto.films;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategory} entity
 */
public class FilmCategoryDto implements Serializable {
    private final FilmCategoryIdDto id;
    private final Date lastUpdate;

    public FilmCategoryDto(FilmCategoryIdDto id, Date lastUpdate) {
        this.id = id;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategoryIdDto getId() {
        return id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

}