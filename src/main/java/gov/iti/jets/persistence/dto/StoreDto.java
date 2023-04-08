package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Store} entity
 */
@XmlRootElement
public class StoreDto implements Serializable {
    @XmlAttribute
    private  Short id;
    @XmlElement
    private  StaffDto managerStaff;
    @XmlElement
    private  Date lastUpdate;
    public StoreDto(){}
    public StoreDto(Short id, StaffDto managerStaff, Date lastUpdate) {
        this.id = id;
        this.managerStaff = managerStaff;
        this.lastUpdate = lastUpdate;
    }

    public Short getId() {
        return id;
    }

    public StaffDto getManagerStaff() {
        return managerStaff;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}