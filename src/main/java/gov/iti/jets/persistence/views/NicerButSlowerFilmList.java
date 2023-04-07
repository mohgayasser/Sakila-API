package gov.iti.jets.persistence.views;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "nicer_but_slower_film_list")
public class NicerButSlowerFilmList {
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
    @Column(name = "actors")
    private String actors;

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

    public String getActors() {
        return actors;
    }

    protected NicerButSlowerFilmList() {
    }
}