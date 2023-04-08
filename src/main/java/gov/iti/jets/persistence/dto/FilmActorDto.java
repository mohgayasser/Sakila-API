package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.dto.films.FilmDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmActor} entity
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmActorDto implements Serializable {
    private  FilmActorIdDto id;
    private  ActorDto actor;

    private  Date lastUpdate;

    public void setId(FilmActorIdDto id) {
        this.id = id;
    }

    public void setActor(ActorDto actor) {
        this.actor = actor;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public FilmActorDto(){}
    public FilmActorDto(FilmActorIdDto id, ActorDto actor, Date lastUpdate) {
        this.id = id;
        this.actor = actor;
        this.lastUpdate = lastUpdate;
    }

    public FilmActorIdDto getId() {
        return id;
    }

    public ActorDto getActor() {
        return actor;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }
}