package gov.iti.jets.persistence.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Actor} entity
 */

public class ActorDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Date lastUpdate;

    public ActorDto(Integer id, String firstName, String lastName, Date lastUpdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}