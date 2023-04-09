package gov.iti.jets.persistence.dto.films;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public class OperationalFilmDto {

    private  String title;

    private  String description;

    private  Integer releaseYear;

    private int languageId;

    private int orignalLanguageId;

    private  Short rentalDuration;

    private     Float rentalRate;
    private  Integer length;

    private    Float replacementCost;

    private String rating;

    private Set<Integer>StoresIds;

    private Date lastUpdate;
    private  Set<Integer> filmActorsIds;

    private Set<Integer> filmCategoriesIds ;

    private   String specialFeatures;

    public OperationalFilmDto() {
    }

    public OperationalFilmDto(String title, String description, Integer releaseYear, int languageId, int orignalLanguageId, Short rentalDuration,     Float rentalRate, Integer length,     Float replacementCost, String rating, Set<Integer> storeId, Date lastUpdate, Set<Integer> filmActorsIds, Set<Integer> filmCategoriesIds,String specialFeatures) {
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
        this.StoresIds = storeId;
        this.lastUpdate = lastUpdate;
        this.filmActorsIds = filmActorsIds;
        this.filmCategoriesIds = filmCategoriesIds;
        this.specialFeatures = specialFeatures;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public int getLanguageId() {
        return languageId;
    }

    public int getOrignalLanguageId() {
        return orignalLanguageId;
    }

    public Short getRentalDuration() {
        return rentalDuration;
    }

    public     Float getRentalRate() {
        return rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public     Float getReplacementCost() {
        return replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public Set<Integer> getStoresIds() {
        return StoresIds;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Set<Integer> getFilmActorsIds() {
        return filmActorsIds;
    }

    public Set<Integer> getFilmCategoriesIds() {
        return filmCategoriesIds;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public void setOrignalLanguageId(int orignalLanguageId) {
        this.orignalLanguageId = orignalLanguageId;
    }

    public void setRentalDuration(Short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public void setRentalRate(    Float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setReplacementCost(    Float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStoresIds(Set<Integer> storesIds) {
        StoresIds = storesIds;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setFilmActorsIds(Set<Integer> filmActorsIds) {
        this.filmActorsIds = filmActorsIds;
    }

    public void setFilmCategoriesIds(Set<Integer> filmCategoriesIds) {
        this.filmCategoriesIds = filmCategoriesIds;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
}
