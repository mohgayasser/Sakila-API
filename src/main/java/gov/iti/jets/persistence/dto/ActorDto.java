package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Actor} entity
 */

@XmlRootElement(name = "Actor")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private  String firstName;
    @XmlElement
    private  String lastName;
    @XmlElement
    private  Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}