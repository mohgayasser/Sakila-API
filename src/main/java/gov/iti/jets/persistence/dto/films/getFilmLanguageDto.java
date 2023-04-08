package gov.iti.jets.persistence.dto.films;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class getFilmLanguageDto implements Serializable {
    @XmlAttribute(name ="languageId")
    private  Short id;
    @XmlElement(name = "languageName")
    private  String name;
    @XmlElement(name = "languageLastUpdate")
    private Date lastUpdate;


    public getFilmLanguageDto(Short id, String name, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public getFilmLanguageDto() {
    }

    public Short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
