package gov.iti.jets.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "film_actor")
public class FilmActor {
    @EmbeddedId
    private FilmActorId id = new FilmActorId();

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "actor_id", nullable = false)
    @JsonIgnore
    private Actor actor;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    @JsonIgnore
    private Film film;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public FilmActor(FilmActorId id, Actor actor, Film film, Date lastUpdate) {
        this.id = id;
        this.actor = actor;
        this.film = film;
        this.lastUpdate = lastUpdate;
    }
    public FilmActor(Actor actor, Film film, Date lastUpdate) {

        this.actor = actor;
        this.film = film;
        this.lastUpdate = lastUpdate;
    }
    public FilmActor(){}

    public FilmActorId getId() {
        return id;
    }

    public void setId(FilmActorId id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}