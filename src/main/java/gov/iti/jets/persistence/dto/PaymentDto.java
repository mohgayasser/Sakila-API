package gov.iti.jets.persistence.dto;


import gov.iti.jets.persistence.dto.customer.CustomerDto;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
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
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class PaymentDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private CustomerDto customer;
    @XmlElement
    private  BigDecimal amount;
    @XmlElement
    private  Date paymentDate;
    @XmlElement
    private  Date lastUpdate;

}