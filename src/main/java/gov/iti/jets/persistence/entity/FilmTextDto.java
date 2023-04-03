package gov.iti.jets.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link FilmText} entity
 */
public class FilmTextDto implements Serializable {
    private final Short id;
    private final String title;
    private final String description;

    public FilmTextDto(Short id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Short getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTextDto entity = (FilmTextDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "description = " + description + ")";
    }
}