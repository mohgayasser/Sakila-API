package gov.iti.jets.presentation.models;

import gov.iti.jets.presentation.models.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
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
public class UpdateActorDto implements Serializable {
    private  Integer id;
    private  String firstName;
    private  String lastName;
}