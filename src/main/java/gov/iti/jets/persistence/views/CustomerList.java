package gov.iti.jets.persistence.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "customer_list")
public class CustomerList {
    @Column(name = "ID", columnDefinition = "SMALLINT UNSIGNED not null")
    @Id
    private Integer id;

    @Size(max = 91)
    @Column(name = "name", length = 91)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Size(max = 10)
    @Column(name = "`zip code`", length = 10)
    private String zipCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Size(max = 50)
    @NotNull
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Size(max = 50)
    @NotNull
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Size(max = 6)
    @NotNull
    @Column(name = "notes", nullable = false, length = 6)
    private String notes;

    @Column(name = "SID", columnDefinition = "TINYINT UNSIGNED not null")
    private Short sid;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public Short getSid() {
        return sid;
    }

    protected CustomerList() {
    }
}