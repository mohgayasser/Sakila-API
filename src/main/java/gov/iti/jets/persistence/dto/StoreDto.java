package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Store} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Store")
@XmlAccessorType(XmlAccessType.FIELD)
public class StoreDto implements Serializable {
    @XmlAttribute
    private  Short id;
    @XmlElement
    private  StaffDto managerStaff;
    @XmlElement
    private  Date lastUpdate;

}