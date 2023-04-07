package gov.iti.jets.persistence.dto.categories;

import gov.iti.jets.persistence.dto.films.FilmCategoryDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Category} entity
 */
public class CategoryWIthFilmsDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Date lastUpdate;
    private final Set<FilmCategoryDto> filmCategories;

    public CategoryWIthFilmsDto(Integer id, String name, Date lastUpdate, Set<FilmCategoryDto> filmCategories) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmCategories = filmCategories;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Set<FilmCategoryDto> getFilmCategories() {
        return filmCategories;
    }

    @Override
    public String toString() {
        return "CategoryWIthFilmsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", filmCategories length=" + filmCategories.size() +
                '}';
    }
}