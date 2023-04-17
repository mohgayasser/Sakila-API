package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.FilmActorDto;
import gov.iti.jets.persistence.entity.enums.FilmRating;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Film} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="film")
@XmlAccessorType(XmlAccessType.FIELD)
public class getFilmDto implements Serializable {
        @XmlAttribute(name = "filmId")
        private    Integer id;
        @XmlAttribute(name = "filmTitle")
        private  String title;
        @XmlElement(name = "filmDescription")
        private  String description;
        @XmlElement
        private  Integer releaseYear;
        @XmlElement(name = "language")
        private getFilmLanguageDto language;
        @XmlElement(name = "orignalLanguage",type = JAXBElement.class, required = false)
        private getFilmLanguageDto orignalLanguage;
        @XmlElement
        private  Short rentalDuration;
         @XmlElement
        private  BigDecimal rentalRate;
         @XmlElement
        private  Integer length;
        @XmlElement
        private  BigDecimal replacementCost;
         @XmlElement
        private  FilmRating rating;
        @XmlElement(name="filmLastUpdate")
        private  Date lastUpdate;
         @XmlElement
        private  Set<getInventoryDto> inventories;
        @XmlElement
        private  Set<FilmActorDto> filmActors;
        @XmlElement( name = "filmCategories")
       private Set<getFilmCategoryDto> filmCategories ;
        @XmlElement
        private   Set<String>specialFeatures;


}