package gov.iti.jets.persistence.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Address} entity
 */

public class AddressDto implements Serializable {
    private final Integer id;
    private final String address;
    private final String address2;
    private final String district;
    private final String postalCode;
    private final String phone;
    private final Date lastUpdate;

    public AddressDto(Integer id, String address, String address2, String district, String postalCode, String phone, Date lastUpdate) {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getDistrict() {
        return district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}