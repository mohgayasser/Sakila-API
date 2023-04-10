package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Rental} entity
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RentalDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private  Date rentalDate;
    @XmlElement
    private  Date returnDate;
    @XmlElement
    private  Date lastUpdate;

    public RentalDto() {
    }

    public RentalDto(Integer id, Date rentalDate, Date returnDate, Date lastUpdate) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}