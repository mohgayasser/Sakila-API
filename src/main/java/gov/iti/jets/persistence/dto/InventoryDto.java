package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.dto.films.FilmDto;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Inventory} entity
 */
@XmlRootElement
public class InventoryDto implements Serializable {
    @XmlAttribute(name = "inventoryId")
    private  Integer id;
    private  FilmDto film;
    private  StoreDto store;
    private  Date lastUpdate;
    public InventoryDto(){}
    public InventoryDto(Integer id, FilmDto film, StoreDto store, Date lastUpdate) {
        this.id = id;
        this.film = film;
        this.store = store;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public FilmDto getFilm() {
        return film;
    }

    public StoreDto getStore() {
        return store;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}