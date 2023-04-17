package gov.iti.jets.presentation.models;

import gov.iti.jets.service.util.customAnnotations.EmptyAnnotation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Staff} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@EmptyAnnotation
@XmlAccessorType(XmlAccessType.FIELD)
public class InsertStaffDto implements Serializable {
    @Size(max = 45,message = "your staff member  first name need to be consist of 45 character  at most")
    private  String firstName;
    @Size(max = 45,message = "your staff member last name need to be consist of 45 character  at most")
    private  String lastName;
    private  AddressDto address;
    private  byte[] picture;
    @Email
    @Size(max = 50,message = "your staff member  email need to be consist of 50 character at most")
    private  String email;
    @Size(max = 16,message = "your staff member  email need to be consist of 16 character at most")
    private  String username;
    @Size(max = 40,message = "your staff member  password need to be consist of 40 character at most")
    private  String password;
    private Integer storeId;
}