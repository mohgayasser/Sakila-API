package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Customer} entity
 */
@XmlRootElement
public class CustomerDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlAttribute
    private  String firstName;
    @XmlAttribute
    private  String lastName;
    @XmlElement
    private  String email;
    @XmlAttribute
    private  Boolean active;
    @XmlElement
    private  Date createDate;
    @XmlElement
    private  Date lastUpdate;
    @XmlElement
    private  Set<RentalDto> rentals;
    public CustomerDto(){}
    public CustomerDto(Integer id, String firstName, String lastName, String email, Boolean active, Date createDate, Date lastUpdate, Set<RentalDto> rentals) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.rentals = rentals;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Set<RentalDto> getRentals() {
        return rentals;
    }
}