package gov.iti.jets.persistence.dto;


import gov.iti.jets.persistence.dto.customer.CustomerDto;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Payment} entity
 */
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
    public PaymentDto(){}
    public PaymentDto(Integer id, CustomerDto customer, BigDecimal amount, Date paymentDate, Date lastUpdate) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}