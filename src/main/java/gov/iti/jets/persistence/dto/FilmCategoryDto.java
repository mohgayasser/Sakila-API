package gov.iti.jets.persistence.dto;

import gov.iti.jets.persistence.dto.films.getFilmDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link gov.iti.jets.persistence.entity.FilmCategory} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class FilmCategoryDto implements Serializable {
    private  FilmCategoryIdDto id;
    private getFilmDto film;
    private  Date lastUpdate;

}