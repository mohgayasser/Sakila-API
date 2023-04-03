package gov.iti.jets.persistence.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

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