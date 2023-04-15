package gov.iti.jets.presentation.dto;

import gov.iti.jets.service.util.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Address} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@EmptyAnnotation
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDto implements Serializable {
    private String address;
    private String address2;
    private String district;
    private String city;
    private String country;
    private String postalCode;
    private String phone;
}