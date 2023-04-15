package gov.iti.jets.persistence.dto.rental;

import gov.iti.jets.persistence.dto.InventoryDto;
import gov.iti.jets.persistence.dto.StaffDto;
import gov.iti.jets.persistence.entity.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Rental} entity
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class RentalDto implements Serializable {
    private  Integer id;
    private  Date rentalDate;
    private  InventoryDto inventory;
    private  CustomerDto customer;
    private  Date returnDate;
    private  StaffDto staff;
    private  Date lastUpdate;
}