package gov.iti.jets.persistence.views;

import gov.iti.jets.service.util.converters.filmListConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.util.List;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "film_list")
public class FilmList {
    @Column(name = "FID", columnDefinition = "SMALLINT UNSIGNED not null")
    @Id
    private Integer fid;

    @Size(max = 128)
    @NotNull
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Size(max = 25)
    @Column(name = "category", length = 25)
    private String category;

    @NotNull
    @Column(name = "price", nullable = false, precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
    private Integer length;

    @Lob
    @Column(name = "rating")
    private String rating;

    @Lob
    @Convert (converter = filmListConverter.class)
    @Column(name = "actors")
    private List<String> actors;

    public FilmList() {
    }

    public Integer getFid() {
        return fid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }

    public List<String> getActors() {
        return actors;
    }

    public FilmList(Integer fid, String title, String description, String category, BigDecimal price, Integer length, String rating, List<String> actors) {
        this.fid = fid;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.length = length;
        this.rating = rating;
        this.actors = actors;
    }
}