package gov.iti.jets.persistence.entity;

import gov.iti.jets.persistence.dto.AddressDto;
import gov.iti.jets.persistence.dto.StoreDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Customer} entity
 */
@AllArgsConstructor
@Getter
public class CustomerDto implements Serializable {
    private final Integer id;
    private final StoreDto store;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final AddressDto address;
    private final Boolean active;
    private final Date createDate;
    private final Date lastUpdate;
}