package gov.iti.jets.presentation.dto;

import gov.iti.jets.service.util.customAnnotations.EmptyAnnotation;
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
