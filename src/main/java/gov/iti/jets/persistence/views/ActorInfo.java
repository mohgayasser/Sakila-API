package gov.iti.jets.persistence.views;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "actor_info")
public class ActorInfo {
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @Id
    private Integer actorId;

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Lob
    @Column(name = "film_info")
    private String filmInfo;

    public Integer getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    protected ActorInfo() {
    }
}