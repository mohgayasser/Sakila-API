package gov.iti.jets.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorId implements Serializable {
    private static final long serialVersionUID = 2601650635923906297L;
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer actorId;

    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer filmId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmActorId entity = (FilmActorId) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.filmId, entity.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

    @Override
    public String toString() {
        return "FilmActorId{" +
                "actorId=" + actorId +
                ", filmId=" + filmId +
                '}';
    }
}