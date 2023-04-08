package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.FilmActorDto;
import gov.iti.jets.persistence.dto.InventoryDto;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.entity.enums.FilmRating;
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
public class FilmDto implements Serializable {
        @XmlAttribute(name = "id")
        private    Integer id;
        @XmlAttribute(name = "title")
        private  String title;
        @XmlElement
        private  String description;
        @XmlElement
        private  Integer releaseYear;
        @XmlElement
        private  LanguageDto language;
        @XmlElement
        private  LanguageDto orignalLanguage;
        @XmlElement
        private  Short rentalDuration;
         @XmlElement
        private  BigDecimal rentalRate;
         @XmlElement
        private  Integer length;
        @XmlElement
        private  BigDecimal replacementCost;
        private  FilmRating rating;
        @XmlElement
        private  Date lastUpdate;


         @XmlElement
        private  Set<InventoryDto> inventories;
        @XmlElement
        private  Set<FilmActorDto> filmActors;
    //    private Set<FilmCategoryDto> filmCategories ;
        public FilmDto(){}

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

        public LanguageDto getLanguage() {
                return language;
        }

        public void setLanguage(LanguageDto language) {
                this.language = language;
        }

        public LanguageDto getOrignalLanguage() {
                return orignalLanguage;
        }

        public void setOrignalLanguage(LanguageDto orignalLanguage) {
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

        public Set<InventoryDto> getInventories() {
                return inventories;
        }

        public void setInventories(Set<InventoryDto> inventories) {
                this.inventories = inventories;
        }

        public Set<FilmActorDto> getFilmActors() {
                return filmActors;
        }

        public void setFilmActors(Set<FilmActorDto> filmActors) {
                this.filmActors = filmActors;
        }
}