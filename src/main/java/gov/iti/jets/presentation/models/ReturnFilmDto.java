package gov.iti.jets.presentation.models;

import gov.iti.jets.presentation.models.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@XmlRootElement
@EmptyAnnotation
public class ReturnFilmDto {

    private Integer customerId;
    private Integer storeId;
    private Integer filmId;
    private Integer numberOfCopies;
}
