package gov.iti.jets.persistence.entity;

import gov.iti.jets.persistence.dto.films.getFilmDto;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link Language} entity
 */
@XmlRootElement(name = "Language")
public class LanguageDto implements Serializable {
    @XmlAttribute
    private  Short id;
    @XmlElement
    private  String name;
    @XmlElement
    private  Date lastUpdate;
    @XmlElement
    private  Set<getFilmDto> films;

    public LanguageDto(Short id, String name, Date lastUpdate, Set<getFilmDto> films) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.films = films;
    }

    public LanguageDto() {
    }

    public Short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Set<getFilmDto> getFilms() {
        return films;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setFilms(Set<getFilmDto> films) {
        this.films = films;
    }
}