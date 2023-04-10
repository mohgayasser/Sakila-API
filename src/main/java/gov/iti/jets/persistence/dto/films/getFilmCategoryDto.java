package gov.iti.jets.persistence.dto.films;

import gov.iti.jets.persistence.dto.categories.getFilmCategoryIdDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.xml.bind.annotation.*;

import java.util.Date;

@XmlRootElement(name="FilmCategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class getFilmCategoryDto {
    @XmlElement(name = "id")
    private getFilmCategoryIdDto id;
    @XmlElement
    @NotNull(message = "Name cannot be null")
    private  String name;
    @XmlElement
    @PastOrPresent(message = "date can not be in the future")
    private Date lastUpdate;

    public getFilmCategoryDto() {
    }
    public getFilmCategoryDto(getFilmCategoryIdDto id, String name, Date lastUpdate) {
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
    public void  setId(getFilmCategoryIdDto id){
        this.id = id;
    }
    public getFilmCategoryIdDto id() {
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
