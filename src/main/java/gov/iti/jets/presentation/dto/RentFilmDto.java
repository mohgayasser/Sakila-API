package gov.iti.jets.presentation.dto;

import gov.iti.jets.service.util.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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