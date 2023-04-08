package gov.iti.jets.persistence.dto.inventory;

import gov.iti.jets.persistence.entity.enums.FilmRating;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Film} entity
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmDto implements Serializable {
    private  Integer id;
    private   String title;
    private   String description;
    private   Integer releaseYear;
    private   Short rentalDuration;
    private   BigDecimal rentalRate;
    private   Integer length;
    private   BigDecimal replacementCost;
    private   FilmRating rating;
    private   Set<String>specialFeatures;
    private   Date lastUpdate;
}