package gov.iti.jets.persistence.dto.customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Staff} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RentalStaffDto implements Serializable {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  byte[] picture;
    private  String email;
    private  String username;
}