package gov.iti.jets.persistence.dto;


import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmActorId} entity
 */

public class FilmActorIdDto implements Serializable {
    private final Integer actorId;
    private final Integer filmId;

    public FilmActorIdDto(Integer actorId, Integer filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public Integer getFilmId() {
        return filmId;
    }
}