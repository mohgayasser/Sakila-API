package gov.iti.jets.presentation.dto;

import jakarta.validation.constraints.*;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationalFilmDto implements Serializable {

    @NotBlank(message = "you need to enter a title for this film")
    @XmlElement(name = "filmTitle")
    private  String title;

    @NotBlank(message = "you need to enter a description for this film")
    @XmlElement(name = "filmDescription")
    private  String description;
    @NotNull(message = "you need to enter a released year of this film")
    @XmlElement
    private  Integer releaseYear;

    @NotNull(message = "you need to enter a language id ")
    @Min(1)
    @XmlElement(name = "languageId")
    private int languageId;
    @XmlElement(name = "orignalLanguage")
    private int orignalLanguageId;

    @NotNull(message = "you need to enter a Duration that this film can be rented during it")
    @Min(value = 0,message = "the rental Duration must be more than one day")
    @XmlElement
    private  Short rentalDuration;

    @NotNull(message = "You Need to Enter a Rental Rate ")
    @Min(0)
    @XmlElement
    private Float rentalRate;

    @NotNull(message = "you need to enter a length of this film")
    @Min(0)
    @XmlElement
    private  Integer length;

    @NotNull (message = "you need to enter a Replacement Cost for this film")
    @Min(0)
    @Digits(integer=5, fraction=2,message = "Replacement cost need to be Decimal number 5 integer digits and 2 fractions after point")
    @XmlElement
    private  Float replacementCost;

    @NotNull (message = "you need to enter Rating for this film ex: G,PG,PG-13,R,NC-17")
    @NotBlank
    @Pattern(regexp = "^(G|PG|PG-13|R|NC_17)$" ,message = "you need to enter on of next values for rating variable ( G,PD,PG-13,R,NC-17)")
    @XmlElement
    private String rating;

    @NotNull(message = "you need to enter at least one store id for this film")
    private Set<Integer> storesIds;

    @NotNull(message = "you need to enter at least one Actor whose in this film")
    @XmlElement
    private  Set<Integer> filmActorsIds;
    @NotNull(message = "you need to enter at least one category that this film categorized under it ")
    @XmlElement( name = "filmCategories")
    private Set<Integer> filmCategoriesIds ;

    @XmlElement
    private  String specialFeatures;

    public OperationalFilmDto(String title, String description, Integer releaseYear, int languageId, int orignalLanguageId, Short rentalDuration,     Float rentalRate, Integer length,     Float replacementCost, String rating, Set<Integer> storeId, Date lastUpdate, Set<Integer> filmActorsIds, Set<Integer> filmCategoriesIds, String specialFeatures) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.orignalLanguageId = orignalLanguageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.storesIds = storeId;
        this.filmActorsIds = filmActorsIds;
        this.filmCategoriesIds = filmCategoriesIds;
        this.specialFeatures = specialFeatures;
    }

    public OperationalFilmDto() {
    }

    @Override
    public String toString() {
        return "OperationalFilmDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", languageId=" + languageId +
                ", orignalLanguageId=" + orignalLanguageId +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating='" + rating + '\'' +
                ", storesIds=" + storesIds +
                ", filmActorsIds=" + filmActorsIds +
                ", filmCategoriesIds=" + filmCategoriesIds +
                ", specialFeatures=" + specialFeatures +
                '}';
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getOrignalLanguageId() {
        return orignalLanguageId;
    }

    public void setOrignalLanguageId(int orignalLanguageId) {
        this.orignalLanguageId = orignalLanguageId;
    }

    public Short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public     Float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(    Float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public     Float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(    Float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Set<Integer> getStoresIds() {
        return storesIds;
    }

    public void setStoresIds(Set<Integer> storesIds) {
        this.storesIds = storesIds;
    }

    public Set<Integer> getFilmActorsIds() {
        return filmActorsIds;
    }

    public void setFilmActorsIds(Set<Integer> filmActorsIds) {
        this.filmActorsIds = filmActorsIds;
    }

    public Set<Integer> getFilmCategoriesIds() {
        return filmCategoriesIds;
    }

    public void setFilmCategoriesIds(Set<Integer> filmCategoriesIds) {
        this.filmCategoriesIds = filmCategoriesIds;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
}
