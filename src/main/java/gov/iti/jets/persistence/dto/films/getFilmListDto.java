package gov.iti.jets.persistence.dto.films;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * A DTO for the {@link gov.iti.jets.persistence.views.FilmList} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class getFilmListDto implements Serializable {
    private  Integer fid;
    @Size(max = 128)
    @NotNull
    private  String title;
    private  String description;
    @Size(max = 25)
    private  String category;
    @NotNull
    private  BigDecimal price;
    private  Integer length;
    private  String rating;
    @XmlElement(name="actor")
    private List<String> actors;

}