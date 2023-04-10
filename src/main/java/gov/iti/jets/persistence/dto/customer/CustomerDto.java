package gov.iti.jets.persistence.dto.customer;


import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Customer} entity
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDto implements Serializable {
    @XmlAttribute
    private  Integer id;
    @XmlElement
    private  String firstName;
    @XmlElement
    private  String lastName;
    @XmlElement
    private  String email;
    @XmlElement
    private  Boolean active;
    @XmlElement
    private  Date createDate;
    @XmlElement
    private  Date lastUpdate;

    public CustomerDto(){}
    public CustomerDto(Integer id, String firstName, String lastName, String email, Boolean active, Date createDate, Date lastUpdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
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


    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}