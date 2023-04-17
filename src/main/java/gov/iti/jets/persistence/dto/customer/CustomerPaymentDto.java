package gov.iti.jets.persistence.dto.customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Payment} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerPaymentDto implements Serializable {
    private  Integer id;
    private  RentalStaffDto staff;
    private  PaymentRentalDto rental;
    private  BigDecimal amount;
    private  Date paymentDate;
    private  Date lastUpdate;
}