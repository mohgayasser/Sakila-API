package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.categories.FilmCategoryIdDto;
import jakarta.xml.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@XmlRootElement(name="FilmCategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmCategoryDto {
    @XmlElement(name = "id")
    private FilmCategoryIdDto id;
    @XmlElement
    @NotNull(message = "Name cannot be null")
    private  String name;
    @XmlElement
    @PastOrPresent(message = "date can not be in the future")
    private Date lastUpdate;

    public FilmCategoryDto() {
    }
    public FilmCategoryDto(FilmCategoryIdDto id, String name, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public void  setId(FilmCategoryIdDto id){
        this.id = id;
    }
    public FilmCategoryIdDto id() {
        return id;
    }
    public String name() {
        return name;
    }
    public Date lastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
