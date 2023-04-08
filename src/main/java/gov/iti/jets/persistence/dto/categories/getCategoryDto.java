package gov.iti.jets.persistence.dto.categories;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Category} entity
 */

@XmlRootElement (name = "Category")
@XmlAccessorType(XmlAccessType.FIELD)
public class getCategoryDto implements Serializable {
    private    Integer id;
    private    String name;
    private    Date lastUpdate;
    private    Set<getFilmCategoryDto> filmCategories;

    public getCategoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<getFilmCategoryDto> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(Set<getFilmCategoryDto> filmCategories) {
        this.filmCategories = filmCategories;
    }
}