package gov.iti.jets.presentation.models;

import gov.iti.jets.service.util.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Customer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@EmptyAnnotation
@XmlAccessorType(XmlAccessType.FIELD)
public class AddCustomerDto implements Serializable {

    private   String firstName;
    private   String lastName;
    private Integer storeId;
    @Email
    private   String email;
    private   AddressDto address;
}