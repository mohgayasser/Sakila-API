package gov.iti.jets.persistence.dto.store;

import gov.iti.jets.presentation.models.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EmptyAnnotation
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateStoreManagerDto {
    private Integer id;
    private Integer ManagerId;
}
