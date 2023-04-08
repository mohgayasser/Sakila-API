package gov.iti.jets.persistence.dto.films;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Inventory} entity
 */



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class getInventoryDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private  Date lastUpdate;
    @XmlElement
    private getStoreDto store;
    public getInventoryDto(){}
    public getInventoryDto(Integer id, Date lastUpdate, getStoreDto store) {
        this.id = id;
        this.lastUpdate = lastUpdate;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setStore(getStoreDto store) {
        this.store = store;
    }

    public getStoreDto getStore() {
        return store;
    }
}