package gov.iti.jets.persistence.dto.films;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
