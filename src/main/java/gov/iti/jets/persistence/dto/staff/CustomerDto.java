package gov.iti.jets.persistence.dto.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Customer} entity
 */
@AllArgsConstructor
@Getter
public class CustomerDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
}