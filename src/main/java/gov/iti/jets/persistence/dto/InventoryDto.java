package gov.iti.jets.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Inventory} entity
 */
@AllArgsConstructor
@Getter
public class InventoryDto implements Serializable {
    private final Integer id;
    private final FilmDto film;
    private final StoreDto store;
    private final Date lastUpdate;
}