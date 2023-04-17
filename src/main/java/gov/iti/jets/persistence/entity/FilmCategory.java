package gov.iti.jets.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "film_category")
public class FilmCategory {
    @EmbeddedId
    private FilmCategoryId id = new FilmCategoryId();

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    @JsonIgnore
    private Film film;


    @JsonIgnore
    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    public FilmCategory(){}
    public FilmCategory(Film film, Category category, Date lastUpdate) {
        this.film = film;
        this.category = category;
        this.lastUpdate = lastUpdate;
    }
    public FilmCategory(FilmCategoryId id, Film film, Category category, Date lastUpdate) {
        this.id = id;
        this.film = film;
        this.category = category;
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "last_update", nullable = false)
    private Date lastUpdate;

    public FilmCategoryId getId() {
        return id;
    }

    public void setId(FilmCategoryId id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "id=" + id +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}