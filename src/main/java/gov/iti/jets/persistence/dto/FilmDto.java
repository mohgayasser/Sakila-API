package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.entity.enums.FilmRating;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Film} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmDto implements Serializable {

    private  Integer id;
    private  String title;
    private  String description;
    private  Integer releaseYear;
    private  LanguageDto language;
    private  LanguageDto originalLanguage;
    private  Short rentalDuration;
    private  Float rentalRate;
    private  Integer length;
    private  Float replacementCost;
    private  FilmRating rating;
    private  Set<String> specialFeatures;
    private  Date lastUpdate;
}