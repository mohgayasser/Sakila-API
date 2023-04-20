package gov.iti.jets.persistence.dto.store;

import gov.iti.jets.presentation.models.StoreManagerStaffDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Store} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StoreManagerDto implements Serializable {
    private  Integer id;
    private StoreManagerStaffDto managerStaff;
}