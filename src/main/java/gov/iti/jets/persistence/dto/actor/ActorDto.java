package gov.iti.jets.persistence.dto.actor;


import gov.iti.jets.presentation.models.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Actor} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EmptyAnnotation
@XmlRootElement(name = "Actor")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorDto implements Serializable {
    @XmlElement
    private  String firstName;
    @XmlElement
    private  String lastName;
}