package gov.iti.jets.presentation.dto;

import jakarta.validation.constraints.*;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
