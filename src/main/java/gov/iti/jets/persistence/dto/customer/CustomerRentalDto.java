package gov.iti.jets.persistence.dto.customer;

import gov.iti.jets.persistence.dto.PaymentDto;
import gov.iti.jets.persistence.dto.StaffDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Rental} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRentalDto implements Serializable {
    private  Integer id;
    private  Date rentalDate;
    private  Date returnDate;
    private  RentalStaffDto staff;
    private  Date lastUpdate;
}