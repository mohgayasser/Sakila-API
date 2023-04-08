package gov.iti.jets.persistence.dto.categories;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategoryId} entity
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Films")
public class getFilmCategoryIdDto implements Serializable {
    private  Integer filmId;
    private  Integer categoryId;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public getFilmCategoryIdDto() {
    }
}