package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmActorId} entity
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmActorIdDto implements Serializable {
    @XmlAttribute
    private  Integer actorId;
    @XmlAttribute
    private  Integer filmId;
    public FilmActorIdDto(){}
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }
}