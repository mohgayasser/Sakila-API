package gov.iti.jets.persistence.dto;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Staff} entity
 */
@XmlRootElement
public class StaffDto implements Serializable {
    @XmlAttribute
    private  Short id;
    @XmlAttribute
    private  String firstName;
    @XmlAttribute
    private  String lastName;
    @XmlElement
    private  AddressDto address;
    @XmlElement
    private  byte[] picture;
    @XmlAttribute
    private  String email;
    @XmlAttribute
    private  Boolean active;
    @XmlElement
    private  String username;
    @XmlElement
    private  String password;
    @XmlElement
    private  Date lastUpdate;
    @XmlElement
    private  Set<PaymentDto> payments;
    @XmlElement
    private  Set<RentalDto> rentals;
    public StaffDto(){}
    public StaffDto(Short id, String firstName, String lastName, AddressDto address, byte[] picture, String email, Boolean active, String username, String password, Date lastUpdate, Set<PaymentDto> payments, Set<RentalDto> rentals) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
        this.rentals = rentals;
    }

    public Short getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Set<PaymentDto> getPayments() {
        return payments;
    }

    public Set<RentalDto> getRentals() {
        return rentals;
    }
}