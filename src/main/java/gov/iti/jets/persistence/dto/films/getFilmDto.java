package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.FilmActorDto;
import gov.iti.jets.persistence.entity.enums.FilmRating;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Film} entity
 */

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

    public Set<String> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Set<String> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public getFilmDto(){}

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Integer getReleaseYear() {
                return releaseYear;
        }

        public void setReleaseYear(Integer releaseYear) {
                this.releaseYear = releaseYear;
        }

        public getFilmLanguageDto getLanguage() {
                return language;
        }

        public void setLanguage(getFilmLanguageDto language) {
                this.language = language;
        }

        public getFilmLanguageDto getOrignalLanguage() {
                return orignalLanguage;
        }

        public void setOrignalLanguage(getFilmLanguageDto orignalLanguage) {
                this.orignalLanguage = orignalLanguage;
        }

        public Short getRentalDuration() {
                return rentalDuration;
        }

        public void setRentalDuration(Short rentalDuration) {
                this.rentalDuration = rentalDuration;
        }

        public BigDecimal getRentalRate() {
                return rentalRate;
        }

        public void setRentalRate(BigDecimal rentalRate) {
                this.rentalRate = rentalRate;
        }

        public Integer getLength() {
                return length;
        }

        public void setLength(Integer length) {
                this.length = length;
        }

        public BigDecimal getReplacementCost() {
                return replacementCost;
        }

        public void setReplacementCost(BigDecimal replacementCost) {
                this.replacementCost = replacementCost;
        }

        public FilmRating getRating() {
                return rating;
        }

        public void setRating(FilmRating rating) {
                this.rating = rating;
        }

        public Date getLastUpdate() {
                return lastUpdate;
        }

        public void setLastUpdate(Date lastUpdate) {
                this.lastUpdate = lastUpdate;
        }

        public Set<getInventoryDto> getInventories() {
                return inventories;
        }

        public void setInventories(Set<getInventoryDto> inventories) {
                this.inventories = inventories;
        }

        public Set<FilmActorDto> getFilmActors() {
                return filmActors;
        }

        public void setFilmActors(Set<FilmActorDto> filmActors) {
                this.filmActors = filmActors;
        }

        public Set<getFilmCategoryDto> getFilmCategories() {
            return filmCategories;
        }

        public void setFilmCategories(Set<getFilmCategoryDto> filmCategories) {
            this.filmCategories = filmCategories;
        }

}