package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Staff} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StaffDto implements Serializable {
    @XmlAttribute
    private  Short id;
    @XmlAttribute
    private  String firstName;
    @XmlAttribute
    private  String lastName;
    @XmlElement
    private  AddressDto address;
    @XmlElement
    private  byte[] picture;
    @XmlAttribute
    private  String email;
    @XmlAttribute
    private  Boolean active;
    @XmlElement
    private  String username;
    private  String password;
    @XmlElement
    private  Date lastUpdate;
    @XmlElement
    private  Set<PaymentDto> payments;
    @XmlElement
    private  Set<RentalDto> rentals;

}