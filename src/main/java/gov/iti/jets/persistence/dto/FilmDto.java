package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.entity.enums.FilmRating;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.Film} entity
 */
@AllArgsConstructor
@Getter
public class FilmDto implements Serializable {
    private final Integer id;
    private final String title;
    private final String description;
    private final Integer releaseYear;
    private final LanguageDto language;
    private final LanguageDto originalLanguage;
    private final Short rentalDuration;
    private final Float rentalRate;
    private final Integer length;
    private final Float replacementCost;
    private final FilmRating rating;
    private final Set<Set<String>> specialFeatures;
    private final Date lastUpdate;
}