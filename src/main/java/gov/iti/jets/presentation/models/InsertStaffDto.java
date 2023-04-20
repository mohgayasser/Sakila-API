package gov.iti.jets.presentation.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Staff} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InsertStaffDto implements Serializable {
  @NotNull (message = "you need to enter data in first name Field")
  @NotBlank (message = "you need to enter data in first name Field")
    @Size(max = 45,message = "your staff member  first name need to be consist of 45 character  at most")
    private  String firstName;
    @NotNull (message = "you need to enter data in last name Field")
    @NotBlank  (message = "you need to enter data in last name Field")
  @Size(max = 45,message = "your staff member last name need to be consist of 45 character  at most")
    private  String lastName;
    @NotNull (message = "you need to enter data in address Field")
    @NotBlank (message = "you need to enter data in address Field")
    private  AddressDto address;
    private  byte[] picture;
    @Email (message = "you need to match the correct pattern of email ex: aaa@a.com")
    @NotNull (message = "you need to enter data in email Field")
    @NotBlank (message = "you need to enter data in email Field")
    @Size(max = 50,message = "your staff member  email need to be consist of 50 character at most")
    private  String email;
    @NotNull (message = "you need to enter data in username Field")
    @NotBlank (message = "you need to enter data in username Field")
    @Size(max = 16,message = "your staff member  email need to be consist of 16 character at most")
    private  String username;
    @NotNull (message = "you need to enter data in password Field")
    @NotBlank (message = "you need to enter data in password Field")
    @Size(max = 40,message = "your staff member  password need to be consist of 40 character at most")
    private  String password;
    @NotNull (message = "you need to enter data in storeIs Field")
    @NotBlank (message = "you need to enter data in storeIs Field")
    private Integer storeId;
}