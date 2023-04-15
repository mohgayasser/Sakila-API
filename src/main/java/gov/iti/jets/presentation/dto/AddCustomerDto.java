package gov.iti.jets.presentation.dto;

import gov.iti.jets.service.util.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

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
    private  Integer id;
    private   String firstName;
    private   String lastName;
    @Email
    private   String email;
    private   AddressDto address;
}