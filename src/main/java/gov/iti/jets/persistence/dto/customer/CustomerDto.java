package gov.iti.jets.persistence.dto.customer;


import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Customer} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private  String firstName;
    @XmlElement
    private  String lastName;
    @XmlElement
    private  String email;
    @XmlElement
    private  Boolean active;
    @XmlElement
    private  Date createDate;
    @XmlElement
    private  Date lastUpdate;


}