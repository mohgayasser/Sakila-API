package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.AddressDto;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Store} entity
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class getStoreDto implements Serializable {
    @XmlAttribute
    private  Short id;
    @XmlElement
    private  AddressDto address;

    public getStoreDto() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}