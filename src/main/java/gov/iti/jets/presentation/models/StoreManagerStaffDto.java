package gov.iti.jets.presentation.models;

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
 * A DTO for the {@link gov.iti.jets.persistence.entity.Staff} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EmptyAnnotation
@XmlAccessorType(XmlAccessType.FIELD)
public class StoreManagerStaffDto implements Serializable {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  Boolean active;
    private  String username;
    private  String password;
    private  Date lastUpdate;
}