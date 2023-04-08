package gov.iti.jets.persistence.dto.categories;

import gov.iti.jets.persistence.entity.Category;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 * A DTO for the {@link Category} entity
 */

@XmlRootElement(name = "Category")
public class CategoryDto implements Serializable{
    @XmlAttribute(name = "id")
    private  Integer id;
    @XmlElement
    @NotNull(message = "Name cannot be null")
    private  String name;
    @XmlElement
    @PastOrPresent (message = "date can not be in the future")
    private  Date lastUpdate;

    /**
     */

    public CategoryDto(Integer id, String name, Date lastUpdate) {
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
    public CategoryDto() {
    }
    public void  setId(Integer id){
        this.id = id;
    }
    public Integer id() {
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