package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.dto.films.FilmDto;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmActor} entity
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmActorDto implements Serializable {
    @XmlElement
    private  FilmActorIdDto id;
    @XmlElement
    private  ActorDto actor;
    @XmlElement
    private  Date lastUpdate;

    public FilmActorDto() {
    }

    public FilmActorIdDto getId() {
        return id;
    }

    public void setId(FilmActorIdDto id) {
        this.id = id;
    }

    public ActorDto getActor() {
        return actor;
    }

    public void setActor(ActorDto actor) {
        this.actor = actor;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}