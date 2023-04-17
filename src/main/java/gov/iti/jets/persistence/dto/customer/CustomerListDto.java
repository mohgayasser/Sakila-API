package gov.iti.jets.persistence.dto.customer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.views.CustomerList} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomerListDto implements Serializable {
    private  Integer id;
    @Size(max = 91)
    private  String name;
    @Size(max = 50)
    @NotNull
    private  String address;
    @Size(max = 10)
    private  String zipCode;
    @Size(max = 20)
    @NotNull
    private  String phone;
    @Size(max = 50)
    @NotNull
    private  String city;
    @Size(max = 50)
    @NotNull
    private  String country;
    @Size(max = 6)
    @NotNull
    private  String notes;
    private  Short sid;
}