package gov.iti.jets.persistence.dto.staff;

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
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShowStaffDto implements Serializable {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  StaffAddressDto address;
    private  byte[] picture;
    private  String email;
    private  String username;
    private  Date lastUpdate;
}