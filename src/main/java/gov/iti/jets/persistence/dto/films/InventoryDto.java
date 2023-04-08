package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.films.StoreDto;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Inventory} entity
 */



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class InventoryDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private  Date lastUpdate;
    @XmlElement
    private StoreDto store;
    public InventoryDto(){}
    public InventoryDto(Integer id, Date lastUpdate, StoreDto store) {
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

    public void setStore(StoreDto store) {
        this.store = store;
    }

    public StoreDto getStore() {
        return store;
    }
}