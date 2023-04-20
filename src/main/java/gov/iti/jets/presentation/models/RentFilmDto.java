package gov.iti.jets.presentation.models;

import gov.iti.jets.presentation.models.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Rental} entity
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@XmlRootElement
@EmptyAnnotation
public class RentFilmDto implements Serializable {

    private Integer customerId;
    private Integer storeId;
    private Integer staffId;
    private Integer filmId;
    private Integer numberOfCopies;


}